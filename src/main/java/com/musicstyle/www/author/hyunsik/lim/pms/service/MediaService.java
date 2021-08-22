package com.musicstyle.www.author.hyunsik.lim.pms.service;

import java.util.List;

import com.musicstyle.www.author.hyunsik.lim.pms.domain.Media;

public interface MediaService {
    List<Media> list(int pageNo, int pageSize);
    Media get(int no);
}
