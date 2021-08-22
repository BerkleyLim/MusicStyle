package com.musicstyle.www.author.hyunsik.lim.pms.dao;

import java.util.List;
import java.util.Map;

import com.musicstyle.www.author.hyunsik.lim.pms.domain.SheetMusic;

public interface SheetMusicDao {
    List<SheetMusic> selectList(Map<String,Object> params);
    SheetMusic selectOne(int no);
}
