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

import com.musicstyle.www.author.hyunsik.lim.pms.service.PracticeRoomService;

@RestController
@RequestMapping("/practiceRoom")
public class PracticeRoomController {
    @Autowired ServletContext sc;
    
    PracticeRoomService practiceRoomService;
    
    @GetMapping("/")
    public ModelAndView movedPrecticeRoom(ModelMap model) {
        return new ModelAndView("forward:/practiceRoom/practiceRoom.html");
    }
    public PracticeRoomController(PracticeRoomService practiceRoomService) {
        this.practiceRoomService = practiceRoomService;
    }
    
    // 리스트 조회
    @RequestMapping("list")
    public Object list(
            @RequestParam(value="pageNo", defaultValue="1") int pageNo,
            @RequestParam(value="pageSize", defaultValue="10") int pageSize) {
        return practiceRoomService.list(pageNo, pageSize);
    }
    
    
    // 리스트 상세 조회
    @RequestMapping("{pno}")
    public Object listDetail(@PathVariable int pno) {
        return practiceRoomService.get(pno);
    }
}