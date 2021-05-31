package com.musicstyle.www.author.hyunsik.lim.pms.domain;

import java.io.Serializable;
import java.sql.Date;

public class Information implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private long ino;
    private String username;
    private int view;
    private String artist;
    private String titie;
    private String img;
    private String genre;
    private Date releaseDate;
    private String albumName;
    private String musicLink;
    private String content;
    private Date uploadDate;
    
}
