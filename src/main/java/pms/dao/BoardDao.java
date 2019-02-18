package bitcamp.java106.pms.dao;

import java.util.List;
import java.util.Map;

import bitcamp.java106.pms.domain.Board;

public interface BoardDao {
    List<Board> selectList(Map<String,Object> params);
    Board selectOne(int no);
    List<Board> commentList(int no);
    List<Board> hashtagList(int no);
    List<Board> isLike(int no);
    int addLike(Map<String,Object> params);
    int deleteLike(Map<String,Object> params);
    List<Board> isLikeOne(Map<String,Object> params);
    int addcomment(Map<String,Object> params);
    Board isWriter(Map<String,Object> params);
    List<Board> selectLink(int no);
    int deleteLink(int no);
    int addLink(Board board);
    Board selectLinkOne();
    void insert(Board board);
    Board selectRecent();
    List<Board> selectMyBoard(int no); // 마이페이지 게시물페이지(게시물 번호, 사진)
    int totalBoardCount(int no);
    
}
