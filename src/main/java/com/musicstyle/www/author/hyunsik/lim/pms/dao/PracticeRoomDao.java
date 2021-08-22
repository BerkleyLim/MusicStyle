package com.musicstyle.www.author.hyunsik.lim.pms.dao;

import java.util.List;
import java.util.Map;

import com.musicstyle.www.author.hyunsik.lim.pms.domain.practiceRoom;

public interface PracticeRoomDao {
    List<practiceRoom> selectList(Map<String,Object> params);
    practiceRoom selectOne(int no);
}
