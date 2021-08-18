package com.musicstyle.www.author.hyunsik.lim.pms.service;

import java.util.List;

import com.musicstyle.www.author.hyunsik.lim.pms.domain.Teacher;

public interface TeacherService {
    List<Teacher> list(int pageNo, int pageSize);
}
