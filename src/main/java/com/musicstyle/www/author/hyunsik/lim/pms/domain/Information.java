package com.musicstyle.www.author.hyunsik.lim.pms.domain;

import java.io.Serializable;
import java.sql.Date;

public class Information implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int ino;
    private String username;
    private int view;
    private String artist;
    private String title;
    private String img;
    private String genre;
    private Date releaseDate;
    private String albumName;
    private String musicLink;
    private String content;
    private Date upLoadDate;
    
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((albumName == null) ? 0 : albumName.hashCode());
        result = prime * result + ((artist == null) ? 0 : artist.hashCode());
        result = prime * result + ((content == null) ? 0 : content.hashCode());
        result = prime * result + ((genre == null) ? 0 : genre.hashCode());
        result = prime * result + ((img == null) ? 0 : img.hashCode());
        result = prime * result + ino;
        result = prime * result + ((musicLink == null) ? 0 : musicLink.hashCode());
        result = prime * result + ((releaseDate == null) ? 0 : releaseDate.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((upLoadDate == null) ? 0 : upLoadDate.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        result = prime * result + view;
        return result;
    }
    
    
    
    public int getIno() {
        return ino;
    }



    public void setIno(int ino) {
        this.ino = ino;
    }



    public String getUsername() {
        return username;
    }



    public void setUsername(String username) {
        this.username = username;
    }



    public int getView() {
        return view;
    }



    public void setView(int view) {
        this.view = view;
    }



    public String getArtist() {
        return artist;
    }



    public void setArtist(String artist) {
        this.artist = artist;
    }



    public String getTitle() {
        return title;
    }



    public void setTitle(String title) {
        this.title = title;
    }



    public String getImg() {
        return img;
    }



    public void setImg(String img) {
        this.img = img;
    }



    public String getGenre() {
        return genre;
    }



    public void setGenre(String genre) {
        this.genre = genre;
    }



    public Date getReleaseDate() {
        return releaseDate;
    }



    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }



    public String getAlbumName() {
        return albumName;
    }



    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }



    public String getMusicLink() {
        return musicLink;
    }



    public void setMusicLink(String musicLink) {
        this.musicLink = musicLink;
    }



    public String getContent() {
        return content;
    }



    public void setContent(String content) {
        this.content = content;
    }



    public Date getUpLoadDate() {
        return upLoadDate;
    }



    public void setUpLoadDate(Date upLoadDate) {
        this.upLoadDate = upLoadDate;
    }




    @Override
    public String toString() {
        return "Information [ino=" + ino + ", username=" + username + ", view=" + view + ", artist=" + artist
                + ", title=" + title + ", img=" + img + ", genre=" + genre + ", releaseDate=" + releaseDate
                + ", albumName=" + albumName + ", musicLink=" + musicLink + ", content=" + content + ", upLoadDate="
                + upLoadDate + "]";
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Information other = (Information) obj;
        if (albumName == null) {
            if (other.albumName != null)
                return false;
        } else if (!albumName.equals(other.albumName))
            return false;
        if (artist == null) {
            if (other.artist != null)
                return false;
        } else if (!artist.equals(other.artist))
            return false;
        if (content == null) {
            if (other.content != null)
                return false;
        } else if (!content.equals(other.content))
            return false;
        if (genre == null) {
            if (other.genre != null)
                return false;
        } else if (!genre.equals(other.genre))
            return false;
        if (img == null) {
            if (other.img != null)
                return false;
        } else if (!img.equals(other.img))
            return false;
        if (ino != other.ino)
            return false;
        if (musicLink == null) {
            if (other.musicLink != null)
                return false;
        } else if (!musicLink.equals(other.musicLink))
            return false;
        if (releaseDate == null) {
            if (other.releaseDate != null)
                return false;
        } else if (!releaseDate.equals(other.releaseDate))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (upLoadDate == null) {
            if (other.upLoadDate != null)
                return false;
        } else if (!upLoadDate.equals(other.upLoadDate))
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        if (view != other.view)
            return false;
        return true;
    }
    
}
