package com.musicstyle.www.author.hyunsik.lim.pms.domain;

import java.io.Serializable;
import java.sql.Date;

public class Information implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private long no;
    private int memno;
    private Date createDate;
    private String content;
    private String path;
    private int count;
    private int like;
    private int commtCnt;
    private String[] boardhashtag;
    private int totalCnt;
    
    // private String profile;
    
    // private String hashtag;
    // private String nickname;
    // private String comments;
    
}
