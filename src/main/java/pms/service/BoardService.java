package bitcamp.java106.pms.service;

import java.util.List;

import bitcamp.java106.pms.domain.Board;

public interface BoardService {
    List<Board> list(int pageNo, int pageSize);
    Board get(int no);
    List<Board> commentList(int no);
    List<Board> hashtagList(int no);
    List<Board> selectListInMain();
    List<Board> isLike(int no);
    int addLike(int no, int memNo);
    int deleteLike(int no, int memNo);
    List<Board> isLikeOne(int no, int memNo);
    int addcomment(int no, String cmmt, int memNo);
    Board isWriter(int no, int memNo);
    List<Board> selectLink(int no);
    int deleteLink(int no);
    int addLink(Board board);
    Board selectLinkOne();
    void add(Board board);
    List<Board> mpboard(int userNo);
    int mpBoardCnt(int userNo);
}
