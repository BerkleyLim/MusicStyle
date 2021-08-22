package com.musicstyle.www.author.hyunsik.lim.pms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.musicstyle.www.author.hyunsik.lim.pms.dao.SheetMusicDao;
import com.musicstyle.www.author.hyunsik.lim.pms.domain.SheetMusic;
import com.musicstyle.www.author.hyunsik.lim.pms.service.SheetMusicService;

@Service
public class SheetMusicServiceImpl implements SheetMusicService {
    SheetMusicDao SheetMusicDao;
   
    public SheetMusicServiceImpl(SheetMusicDao SheetMusicDao) {
        this.SheetMusicDao = SheetMusicDao;
    }
   
    @Override
    public List<SheetMusic> list(int pageNo, int pageSize) {
        // TODO Auto-generated method stub
        HashMap<String,Object> params = new HashMap<>();
        params.put("startRowNo", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
       
        System.out.println((pageNo - 1) * pageSize);
        System.out.println(pageSize);
       
        return SheetMusicDao.selectList(params);
    }
    
    @Override
    public SheetMusic get(int no) {
        // TODO Auto-generated method stub
        return SheetMusicDao.selectOne(no);
    }
   
}
