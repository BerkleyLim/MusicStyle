package com.musicstyle.www.author.hyunsik.lim.pms.service;

import java.util.List;

import com.musicstyle.www.author.hyunsik.lim.pms.domain.PracticeRoom;

public interface PracticeRoomService {
    List<PracticeRoom> list(int pageNo, int pageSize);
    PracticeRoom get(int no);
}
