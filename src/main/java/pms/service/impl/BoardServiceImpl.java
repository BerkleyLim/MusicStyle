package bitcamp.java106.pms.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.dao.MainDao;
import bitcamp.java106.pms.dao.TagDao;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.domain.Tag;
import bitcamp.java106.pms.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

    BoardDao boardDao;
    MainDao mainDao;
    TagDao tagDao;
    
    public BoardServiceImpl(TagDao tagDao, BoardDao boardDao, MainDao mainDao) {
        this.boardDao = boardDao;
        this.mainDao = mainDao;
        this.tagDao = tagDao;
    }
    
    @Override
    public List<Board> list(int pageNo, int pageSize) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("startRowNo", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
        
        System.out.println((pageNo - 1) * pageSize);
        System.out.println(pageSize);
        
        return boardDao.selectList(params);
    }
    @Override
    public int addLike(int no, int memNo) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("no", no);
        params.put("memNo",memNo);
        return boardDao.addLike(params);
    }
    @Override
    public int deleteLike(int no, int memNo) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("no", no);
        params.put("memNo",memNo);
        return boardDao.deleteLike(params);
    }
    @Override
    public List<Board> isLikeOne(int no, int memNo) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("no", no);
        params.put("memNo", memNo);
        return boardDao.isLikeOne(params);
    }
    @Override
    public Board get(int no) {
        return boardDao.selectOne(no);
    }

    @Override
    public List<Board> commentList(int no) {
        return boardDao.commentList(no);
    }

    @Override
    public List<Board> hashtagList(int no) {
        return boardDao.hashtagList(no);
    }

    @Override
    public List<Board> selectListInMain() {
        System.out.println("Service.selectListInMain");
        return mainDao.selectListInMain();
    }

    @Override
    public List<Board> isLike(int no) {
        return boardDao.isLike(no);
    }

    @Override
    public int addcomment(int no, String cmmt, int memNo) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("no", no);
        params.put("cmmt",cmmt);
        params.put("memNo",memNo);

        return boardDao.addcomment(params);
    }

    @Override
    public Board isWriter(int no, int memNo) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("no", no);
        params.put("memNo", memNo);
        
        return boardDao.isWriter(params);
    }

    @Override
    public List<Board> selectLink(int no) {
        return boardDao.selectLink(no);
    }

    @Override
    public int deleteLink(int no) {
        return boardDao.deleteLink(no);
    }

    @Override
    public int addLink(Board board) {
        return boardDao.addLink(board);
    }

    @Override
    public Board selectLinkOne() {
        return boardDao.selectLinkOne();
    }

    @Override
    public void add(Board board) {
        
        boardDao.insert(board);
        
        String tagResult = Arrays.toString(board.getBoardhashtag());
        String[] arr = (tagResult.substring(1, tagResult.length()-1)).split(", ");
        
        int boardNo = boardDao.selectRecent().getNo();
        
        for(int i = 0; i < arr.length; i++) {
            Tag tag = new Tag();
            String tagValue = arr[i];
            tag.setTagName(tagValue);
            

            tagDao.insert(tag);
            int tagNo = tagDao.getTag(tagValue).getHashTagNo();
            
            Tag boardMatch = new Tag();
            boardMatch.setHashTagNo(tagNo);
            boardMatch.setBoardMatchNo(boardNo);
            tagDao.boardMatchInsert(boardMatch);
            
            
        }
    }

    @Override
    public List<Board> mpboard(int no) {
        return boardDao.selectMyBoard(no);
    }

    @Override
    public int mpBoardCnt(int no) {
        return boardDao.totalBoardCount(no);
    }
    


}
