package com.musicstyle.www.author.hyunsik.lim.pms.web.json;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.musicstyle.www.author.hyunsik.lim.pms.service.MediaService;

@RestController
@RequestMapping("/media")
public class MediaController {
    @Autowired ServletContext sc;
    
    MediaService mediaService;
    
    @GetMapping("/")
    public ModelAndView movedMedia(ModelMap model) {
        return new ModelAndView("forward:/media/media.html");
    }
    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }
    
    // 리스트 조회
    @RequestMapping("list")
    public Object list(
            @RequestParam(value="pageNo", defaultValue="1") int pageNo,
            @RequestParam(value="pageSize", defaultValue="10") int pageSize) {
        return mediaService.list(pageNo, pageSize);
    }
    
    
    // 리스트 상세 조회
    @RequestMapping("{ino}")
    public Object listDetail(@PathVariable int ino) {
        return mediaService.get(ino);
    }
    
}