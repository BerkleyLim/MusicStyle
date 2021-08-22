package com.musicstyle.www.author.hyunsik.lim.pms.dao;

import java.util.List;
import java.util.Map;

import com.musicstyle.www.author.hyunsik.lim.pms.domain.PracticeRoom;

public interface PracticeRoomDao {
    List<PracticeRoom> selectList(Map<String,Object> params);
    PracticeRoom selectOne(int no);
}
