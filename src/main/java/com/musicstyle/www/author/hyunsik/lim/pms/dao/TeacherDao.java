package com.musicstyle.www.author.hyunsik.lim.pms.dao;

import java.util.List;
import java.util.Map;

import com.musicstyle.www.author.hyunsik.lim.pms.domain.Teacher;

public interface TeacherDao {
    List<Teacher> selectList(Map<String,Object> param);
}
