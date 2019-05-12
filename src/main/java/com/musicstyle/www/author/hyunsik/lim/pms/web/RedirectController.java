package com.musicstyle.www.author.hyunsik.lim.pms.web;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

// 여기는 페이지 이동 설정
@RestController
@RequestMapping("/")
public class RedirectController {
//    
//    @Autowired ServletContext sc;
//    
    @GetMapping("/information")
    public ModelAndView redirectWithUsingRedirectPrefix(ModelMap model) {
//        model.addAttribute("attribute", "redirectWithRedirectPrefix");
        //model.addAttribute("attribute", "redirectWithRedirectPrefix");
        //return new ModelAndView("redirect:/redirectedUrl", model);
        return new ModelAndView("forward:/information/information.html");
    }
    
}