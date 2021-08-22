package com.musicstyle.www.author.hyunsik.lim.pms.web.json;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.musicstyle.www.author.hyunsik.lim.pms.domain.Information;
import com.musicstyle.www.author.hyunsik.lim.pms.service.InformationService;

@RestController
@RequestMapping("/information")
public class InformationController {
    @Autowired ServletContext sc;
    
    InformationService informationService;

    @GetMapping("/")
    public ModelAndView movedInformation(ModelMap model) {
        return new ModelAndView("forward:/information/information.html");
    }
    
    public InformationController(InformationService informationService) {
        this.informationService = informationService;
    }
    
    // 파일 입력시
    @RequestMapping("add")
    public Object add(Information information, 
            MultipartFile[] files, HttpSession session) {
        
        return null;
    }
    
    // 리스트 조회
    @RequestMapping("list")
    public Object list(
            @RequestParam(value="pageNo", defaultValue="1") int pageNo,
            @RequestParam(value="pageSize", defaultValue="10") int pageSize) {
        return informationService.list(pageNo, pageSize);
    }
    
    
    // 리스트 상세 조회
    @RequestMapping("{ino}")
    public Object listDetail(@PathVariable int ino) {
        return informationService.get(ino);
    }
    
//    
//    BoardService boardService;
//    
//    public BoardController(BoardService boardService) {
//        this.boardService = boardService;
//    }
//    
//    @RequestMapping("add")
//    public Object add(Board board, MultipartFile[] files, HttpSession session) {
//        Member member = (Member)session.getAttribute("loginUser");
//        int userNo = member.getNo();
//        
//        board.setMemno(userNo);
//        
//        HashMap<String,Object> jsonData = new HashMap<>();
//        
//        MultipartFile file = files[0];
//        
//        String filesDir = sc.getRealPath("/files/board");
//        String filename = UUID.randomUUID().toString();
//        jsonData.put("filename", filename);
//        jsonData.put("filesize", file.getSize());
//        jsonData.put("originname", file.getOriginalFilename());
//        
//        try {
//            File path = new File(filesDir + "/" + filename);
//            file.transferTo(path);
//            System.out.println(path);
//            
//            Thumbnails.of(path)
//            .size(400, 400)
//            .outputFormat("jpg")
//            .toFile(path.getCanonicalPath()+"_400x400");
//            
//            Thumbnails.of(path)
//            .size(800, 800)
//            .outputFormat("jpg")
//            .toFile(path.getCanonicalPath()+"_800x800");
//            
//            Thumbnails.of(path)
//            .size(1000, 1000)
//            .outputFormat("jpg")
//            .toFile(path.getCanonicalPath()+"_1000x1000");
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//        board.setPath(filename);
//        
//        boardService.add(board);
//        
//        jsonData.put("status", "success");
//        return jsonData;
//    }
//    
//    @RequestMapping("mpboard")
//    public List<Board> mpboard(HttpSession session) {
//        Member member = (Member)session.getAttribute("loginUser");
//        int userNo = member.getNo();
//        return boardService.mpboard(userNo);
//    }
//    
//    @RequestMapping("mpBoardCnt")
//    public int mpBoardCnt(HttpSession session) {
//        Member member = (Member)session.getAttribute("loginUser");
//        int userNo = member.getNo();
//        return boardService.mpBoardCnt(userNo);
//    }
//    
//    
//    @RequestMapping("list")
//    public Object list(
//            @RequestParam(value="pageNo", defaultValue="1") int pageNo,
//            @RequestParam(value="pageSize", defaultValue="5") int pageSize) {
//        
//        return boardService.list(pageNo, pageSize);
//    }
//    @RequestMapping("addlike{no}")
//    public Object addLike(@PathVariable int no,HttpSession session) throws Exception {
//        Member member = (Member)session.getAttribute("loginUser");
//        
//        if(member == null) {
//            System.out.println("notLogined");
//            return "notLogined";
//        }
//                
//        return boardService.addLike(no, member.getNo());
//    }
//    @RequestMapping("deletelike{no}")
//    public Object deleteLike(@PathVariable int no,HttpSession session) throws Exception {
//        Member member = (Member)session.getAttribute("loginUser");
//        int memNo = member.getNo();
//        
//        return boardService.deleteLike(no, memNo);
//    }
//    @RequestMapping("islikeone{no}")
//    public Object isLikeOne(@PathVariable int no, HttpSession session) throws Exception {
//        Member member = (Member)session.getAttribute("loginUser");
//        if(member == null) {
//            System.out.println("notLogined");
//            return "notLogined";
//        };
//        
//        return boardService.isLikeOne(no, member.getNo());
//    }
//    @RequestMapping("{no}")
//    public Board view(@PathVariable int no) throws Exception {
//        return boardService.get(no);
//    }
//    
//    @RequestMapping("comment{no}")
//    public Object commentList(@PathVariable int no) throws Exception {
//        return boardService.commentList(no);
//    }
//    
//    @RequestMapping("hashtag{no}")
//    public Object hashtagList(@PathVariable int no) throws Exception {
//        return boardService.hashtagList(no);
//    }
//    
//    @RequestMapping("islike")
//    public Object isLike(HttpSession session) throws Exception {
//        Member member = (Member)session.getAttribute("loginUser");
//        try {
//            return boardService.isLike(member.getNo());
//        } catch(Exception e) {
//            return "fail";
//        }
//    }
//    
//    @RequestMapping("addcmmt/{no}/{cmmt}")
//    public Object addcomment(
//            @PathVariable int no, 
//            @PathVariable String cmmt, 
//            HttpSession session) throws Exception {
//        Member member = (Member)session.getAttribute("loginUser");
//        if(member == null) {
//            System.out.println("notLogined");
//            return "notLogined";
//        };
//        return boardService.addcomment(no, cmmt, member.getNo());
//    }
//    
//    @RequestMapping("isWriter{no}")
//    public Object isWriter(@PathVariable int no, HttpSession session) throws Exception {
//        Member member = (Member)session.getAttribute("loginUser");
//        if(member == null) {
//            System.out.println("notLogined");
//            return "notLogined";
//        };
//        
//        return boardService.isWriter(no, member.getNo());
//    }
//    
//    @RequestMapping("selectLink{no}")
//    public Object selectLink(@PathVariable int no) throws Exception {
//        return boardService.selectLink(no);
//    }
//    
//    @RequestMapping("deleteLink{no}")
//    public Object deleteLink(@PathVariable int no) throws Exception {
//        return boardService.deleteLink(no);
//    }
//    
//    @RequestMapping("addLink")
//    public Object addLink(Board board) throws Exception {
//        return boardService.addLink(board);
//    }
//    
//    @RequestMapping("selectLinkOne")
//    public Object selectLinkOne() throws Exception {
//        return boardService.selectLinkOne();
//    }
}