// 로그인 폼 출력과 사용자 인증처리 서블릿
package bitcamp.java106.pms.web.json;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.service.FacebookService;
import bitcamp.java106.pms.service.KakaoService;
import bitcamp.java106.pms.service.MemberService;

//import bitcamp.java106.pms.service.NaverService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    MemberService memberService;
    @Autowired FacebookService facebookService;
    @Autowired KakaoService kakaoService;

    //@Autowired NaverService naverService;
    
    public AuthController(MemberService memberService) {
        this.memberService = memberService;
    }
    
    @GetMapping("/loginUser")
    public Member loginUser(HttpSession session) {
        return (Member) session.getAttribute("loginUser");
    }
    
    // 페이스북용 로그인
    @RequestMapping(value="facebookLogin")
    public Object facebookLogin(
            @RequestParam("accessToken") String accessToken, 
            HttpSession session) {

        try {
            @SuppressWarnings("rawtypes")
            Map userInfo = facebookService.me(accessToken, Map.class);
            
            // 여기는 번호를 저장하는 값
            int no;
            try { // 자꾸 이부분 때문에 오류 발생으로 예외처리로 대신해줌
                no = memberService.memberNumber((String)userInfo.get("id"));
            } catch (Exception e) {
                no = 0;
            }
            
            Member member = memberService.get(no);
            
            
            if (member == null) { // 등록된 회원이 아니면,
                // 페이스북에서 받은 정보로 회원을 자동 등록한다.
                member = new Member();
                member.setId((String)userInfo.get("id") + "@facebook.com");
                member.setName((String)userInfo.get("name"));
                member.setPassword("1111");
                member.setNickname((String)userInfo.get("name"));
                member.setPhoneNumber("01011111111");
                memberService.add(member);
            }
            
            session.setAttribute("loginUser", member);
            
            HashMap<String,Object> result = new HashMap<>();
            result.put("status", "success");
            return result;
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
            HashMap<String,Object> result = new HashMap<>();
            result.put("status", "fail");
            return result;
        }
    }

    
    @RequestMapping(value="kakaoLogin")
    public Object kakaoLogin(
            @RequestParam("accessToken") String accessToken, 
            HttpSession session,
            Model model) {

        try {
            // Facebook에서 사용자 정보를 가져온다.
            @SuppressWarnings("rawtypes")
            Map koResponse = kakaoService.me(accessToken, Map.class);
            if (koResponse.get("error") != null) {
                model.addAttribute("loginUser", null);
                HashMap<String,Object> result = new HashMap<>();
                result.put("status", "fail"); 
                return result;
            }
            int no;
            try { // 자꾸 이부분 때문에 오류 발생으로 예외처리로 대신해줌
                no = memberService.memberNumber((String)koResponse.get("kaccount_email"));
            } catch (Exception e) {
                no = 0;
            }
            // 이메일로 회원 정보를 찾는다.
            Member member = memberService.get(no);
            if (member == null) {
                // 회원 정보가 없으면 카카오톡 회원 정보를 등록한다.
                member = new Member();
                member.setId((String)koResponse.get("kaccount_email"));
                member.setName((String)((Map)koResponse.get("properties")).get("nickname"));
                member.setPassword("1111");
                member.setNickname((String)((Map)koResponse.get("properties")).get("nickname"));
                member.setPhoneNumber("01011111111");
                memberService.add(member);
            }

            session.setAttribute("loginUser", member);

            HashMap<String,Object> result = new HashMap<>();
            result.put("status", "success");
            return result;
        } catch (Exception e) {
            HashMap<String,Object> result = new HashMap<>();
            result.put("status", "fail");
            result.put("exception", e.getStackTrace());
            return result;
        }
    }

    /*
    @RequestMapping(value="naverLogin")
    public Object naverLogin(
            @RequestParam("accessToken") String accessToken,
            HttpSession session,
            HttpServletRequest request,
            Model model) {

        try {
            @SuppressWarnings("rawtypes")
            Map userInfo = naverService.me(accessToken, Map.class);
            
            // 여기는 번호를 저장하는 값
            int no;
            try { // 자꾸 이부분 때문에 오류 발생으로 예외처리로 대신해줌
                no = memberService.memberNumber((String)userInfo.get("email"));
            } catch (Exception e) {
                no = 0;
            }
            
            Member member = memberService.get(no);
            
            
            if (member == null) { // 등록된 회원이 아니면,
                // 페이스북에서 받은 정보로 회원을 자동 등록한다.
                member = new Member();
                member.setId((String)userInfo.get("email"));
                member.setName((String)userInfo.get("name"));
                member.setPassword("1111");
                member.setNickname((String)userInfo.get("name"));
                member.setPhoneNumber("-");
                memberService.add(member);
            }
            
            session.setAttribute("loginUser", member);
            
            HashMap<String,Object> result = new HashMap<>();
            result.put("status", "success");
            return result;
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
            HashMap<String,Object> result = new HashMap<>();
            result.put("status", "fail");
            return result;
        }
    }
    */
    
    
    
    
    
    // 일반 로그인
    @RequestMapping("/login")
    public Object login(
            @RequestParam("id") String id,
            @RequestParam("password") String password,
            @RequestParam(value="saveId",required=false) String saveId,
            HttpServletResponse response,
            HttpSession session) throws Exception {
        
        Cookie cookie = null;
        if (saveId != null) {
            // 입력폼에서 로그인할 때 사용한 ID를 자동으로 출력할 수 있도록 
            // 웹브라우저로 보내 저장시킨다.
            cookie = new Cookie("id", id);
            cookie.setMaxAge(60 * 60 * 24 * 7);
        } else { // "아이디 저장" 체크박스를 체크하지 않았다면 
            cookie = new Cookie("id", "");
            cookie.setMaxAge(0); // 웹브라우저에 "id"라는 이름으로 저장된 쿠키가 있다면 제거한다.
            // 즉 유효기간을 0으로 설정함으로써 "id"라는 이름의 쿠키를 무효화시키는 것이다.
        }
        response.addCookie(cookie);
        
        HashMap<String, Object> result = new HashMap<>();
        if (memberService.isExist(id, password)) { // 로그인 성공!
            session.setAttribute("loginUser", memberService.get(memberService.memberNumber(id)));
            result.put("state", "success");

        } else { // 로그인 실패!
            session.invalidate();
            result.put("state", "fail");
        }
        return result;
    }
    
    @RequestMapping("/logout")
    public void logout(SessionStatus status, HttpSession session) throws Exception {
        // @SessionAttributes에서 관리하는 세션 데이터를 모두 제거한다.
        status.setComplete();
        
        // 세션을 꺼내 무효화시킨다.
        session.invalidate();
    }
    
    // 여기는 회원 아이디 찾기 부분에서 "이름", "휴대폰 번호"를 찾도록 하는 것이다.
    @RequestMapping("/searchId")
    public String searchId(
            @RequestParam("name") String name,
            @RequestParam("phoneNumber") String phoneNumber,
            HttpSession session) {
        
        // searchId : "이름"과 "휴대폰" 조건이 일치하면 "아이디(이메일)" 값을 불려온다.
        String searchId = memberService.searchId(name, phoneNumber);
        
        String result = null;
       
        // searchId 가 null 인경우 : 조회 실패
        // searchId 가 null 이 아닌 경우 : 유저가 등록되어있음
        if (searchId != null) {
            // request는 유효범위가 요청 후 종료이기 때문에 범위를 늘려
            // session에다가 저장했다.
            session.setAttribute("searchId", searchId);
            result = "success"; // 결과값을 success로 조건문 용으로 둔다.
        }
            
        return result; // success // null 둘중 하나로
    }
    
    // 이부분은 "이름", "휴대폰" 입력 후 최종적으로 아이디를 보여주는 것이다.
    // 이 메소드를 사용하기 전재 조건 : 위에 있는 searchId에서 먼저 세션값을 종료시킨다.
    @GetMapping("/searchIdEnd")
    public String searchIdEnd(
            HttpSession session) {
        // 세션을 계속 남겨두기에는 비효율성을 유발하는 것이기 때문에
        // 미리 searchId에 따로 변수로 저장하고 만료시키는 방법을 사용하였다.
        String searchId = (String) session.getAttribute("searchId");
        session.invalidate(); // 여기는 세션 종료 시킨다 (찾은 아이디의 대해 세션이 남으면 안되기 때문에)
        return searchId;
    }
    
    @RequestMapping("/searchPassword")
    public int searchPassword(
            @RequestParam("id") String id,
            HttpSession session) throws Exception {
        // 아이디가 일치하면?
        if (memberService.isSearchPassword(id)) {
            int no = memberService.memberNumber(id);
            session.setAttribute("no", no);
            return no;
        }
        
        // 아이디가 일치하지 않으면?
        return -1;
    }
    
    @RequestMapping("/searchPasswordChange")
    @ResponseStatus(HttpStatus.OK)
    public void changePassword(
            @RequestParam("password") String password,
            HttpSession session) {
        int no = (int) session.getAttribute("no");
        session.invalidate(); // 여기는 세션 종료 시킨다 (찾은 회원정보의 대해 세션이 남으면 안되기 때문에)
        memberService.changePassword(no, password);
    }
    
}

