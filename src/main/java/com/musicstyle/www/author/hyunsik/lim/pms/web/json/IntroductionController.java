package com.musicstyle.www.author.hyunsik.lim.pms.web.json;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/introduction")
public class IntroductionController {
    @Autowired ServletContext sc;
    
    @GetMapping("/")
    public ModelAndView movedInformation(ModelMap model) {
        return new ModelAndView("forward:/introduction/introduction.html");
    }
}