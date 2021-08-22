package com.musicstyle.www.author.hyunsik.lim.pms.service;

import java.util.List;

import com.musicstyle.www.author.hyunsik.lim.pms.domain.SheetMusic;

public interface SheetMusicService {
    List<SheetMusic> list(int pageNo, int pageSize);
    SheetMusic get(int no);
}
