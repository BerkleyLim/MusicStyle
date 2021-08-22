package com.musicstyle.www.author.hyunsik.lim.pms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.musicstyle.www.author.hyunsik.lim.pms.dao.SheetMusicDao;
import com.musicstyle.www.author.hyunsik.lim.pms.domain.SheetMusic;
import com.musicstyle.www.author.hyunsik.lim.pms.service.BoardService;

@Service
public class SheetMusicServiceImpl implements BoardService {
    SheetMusicDao SheetMusicDao;
   // MainDao mainDao;
   // TagDao tagDao;
   
    public SheetMusicServiceImpl(/*TagDao tagDao, BoardDao boardDao,*/ SheetMusicDao SheetMusicDao) {
        this.SheetMusicDao = SheetMusicDao;
//        this.mainDao = mainDao;
//        this.tagDao = tagDao;
    }
   
    @Override
    public List<SheetMusic> list(int pageNo, int pageSize) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("startRowNo", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
       
        System.out.println((pageNo - 1) * pageSize);
        System.out.println(pageSize);
       
        return SheetMusicDao.selectList(params);
    }
    
     @Override
     public SheetMusic get(int no) {
         return SheetMusicDao.selectOne(no);
     }
   
}
