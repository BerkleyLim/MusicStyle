package com.musicstyle.www.author.hyunsik.lim.pms.web.json;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

// 여기는 페이지 이동 설정
@RestController
@RequestMapping("/")
public class RedirectController {
    @GetMapping("/information")
    public ModelAndView movedInformation(ModelMap model) {
        return new ModelAndView("forward:/information/information.html");
    }
    
    @GetMapping("/sheetmusic")
    public ModelAndView movedSheetMusic(ModelMap model) {
        return new ModelAndView("forward:/sheetmusic/sheetmusic.html");
    }
    
    @GetMapping("/media")
    public ModelAndView movedMedia(ModelMap model) {
        return new ModelAndView("forward:/media/media.html");
    }
    
    @GetMapping("/introduction")
    public ModelAndView movedIntroduction(ModelMap model) {
//        model.addAttribute("attribute", "redirectWithRedirectPrefix");
        //model.addAttribute("attribute", "redirectWithRedirectPrefix");
        //return new ModelAndView("redirect:/redirectedUrl", model);
        return new ModelAndView("forward:/introduction/introduction.html");
    }
    
    @GetMapping("/practiceroom")
    public ModelAndView movedPrecticeRoom(ModelMap model) {
        return new ModelAndView("forward:/practiceRoom/practiceRoom.html");
    }
    
    @GetMapping("/teacher")
    public ModelAndView movedTeacher(ModelMap model) {
        return new ModelAndView("forward:/teacher/teacher.html");
    }
    
    @GetMapping("/community")
    public ModelAndView redirectWithUsingRedirectPrefix(ModelMap model) {
//        model.addAttribute("attribute", "redirectWithRedirectPrefix");
        //model.addAttribute("attribute", "redirectWithRedirectPrefix");
        //return new ModelAndView("redirect:/redirectedUrl", model);
        return new ModelAndView("forward:/community/community.html");
    }
    
}