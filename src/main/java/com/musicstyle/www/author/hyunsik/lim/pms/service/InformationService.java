package com.musicstyle.www.author.hyunsik.lim.pms.service;

import java.util.List;

import com.musicstyle.www.author.hyunsik.lim.pms.domain.Information;

public interface InformationService {
    List<Information> list(int pageNo, int pageSize);
    Information get(int no);
    // List<Board> commentList(int no);
    // List<Board> hashtagList(int no);
    // List<Board> selectListInMain();
    // List<Board> isLike(int no);
    // int addLike(int no, int memNo);
    // int deleteLike(int no, int memNo);
    // List<Board> isLikeOne(int no, int memNo);
    // int addcomment(int no, String cmmt, int memNo);
    // Board isWriter(int no, int memNo);
    // List<Board> selectLink(int no);
    // int deleteLink(int no);
    // int addLink(Board board);
    // Board selectLinkOne();
    // void add(Board board);
    // List<Board> mpboard(int userNo);
    // int mpBoardCnt(int userNo);
}
