package com.musicstyle.www.author.hyunsik.lim.pms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.musicstyle.www.author.hyunsik.lim.pms.dao.MediaDao;
import com.musicstyle.www.author.hyunsik.lim.pms.domain.Media;
import com.musicstyle.www.author.hyunsik.lim.pms.service.MediaService;

@Service
public class MediaServiceImpl implements MediaService {

    MediaDao MediaDao;
   // MainDao mainDao;
   // TagDao tagDao;
   
    public MediaServiceImpl(/*TagDao tagDao, BoardDao boardDao,*/ MediaDao MediaDao) {
        this.MediaDao = MediaDao;
//        this.mainDao = mainDao;
//        this.tagDao = tagDao;
    }
   
    @Override
    public List<Media> list(int pageNo, int pageSize) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("startRowNo", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
       
        System.out.println((pageNo - 1) * pageSize);
        System.out.println(pageSize);
       
        return MediaDao.selectList(params);
    }
    
     @Override
     public Media get(int no) {
         return MediaDao.selectOne(no);
     }
   
}
