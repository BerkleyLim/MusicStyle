package com.musicstyle.www.author.hyunsik.lim.pms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.musicstyle.www.author.hyunsik.lim.pms.dao.TeacherDao;
import com.musicstyle.www.author.hyunsik.lim.pms.domain.Teacher;
import com.musicstyle.www.author.hyunsik.lim.pms.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {
    
    TeacherDao teacherdao;
    
    public TeacherServiceImpl(TeacherDao teacherdao) {
        teacherdao = this.teacherdao;
    }

    @Override
    public List<Teacher> list(int pageNo, int pageSize) {
        // TODO Auto-generated method stub
        HashMap<String,Object> params = new HashMap<>();
        params.put("startRowNo", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
       
        System.out.println((pageNo - 1) * pageSize);
        System.out.println(pageSize);
       
        return teacherDao.selectList(params);
    }
}
