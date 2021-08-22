package com.musicstyle.www.author.hyunsik.lim.pms.dao;

import java.util.List;
import java.util.Map;

import com.musicstyle.www.author.hyunsik.lim.pms.domain.Media;

public interface MediaDao {
    List<Media> selectList(Map<String,Object> params);
    Media selectOne(int no);
}