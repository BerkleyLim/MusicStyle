package com.musicstyle.www.author.hyunsik.lim.pms.dao;

import java.util.List;
import java.util.Map;

import com.musicstyle.www.author.hyunsik.lim.pms.domain.Information;

public interface InformationDao {
     List<Information> selectList(Map<String,Object> params);
//     Information selectOne(int no);
    // List<Information> commentList(int no);
    // List<Information> hashtagList(int no);
    // List<Information> isLike(int no);
    // int addLike(Map<String,Object> params);
    // int deleteLike(Map<String,Object> params);
    // List<Information> isLikeOne(Map<String,Object> params);
    // int addcomment(Map<String,Object> params);
    // Information isWriter(Map<String,Object> params);
    // List<Information> selectLink(int no);
    // int deleteLink(int no);
    // int addLink(Information Information);
    // Information selectLinkOne();
    // void insert(Information Information);
    // Information selectRecent();
    // List<Information> selectMyInformation(int no); // 마이페이지 게시물페이지(게시물 번호, 사진)
    // int totalInformationCount(int no);
    
}
