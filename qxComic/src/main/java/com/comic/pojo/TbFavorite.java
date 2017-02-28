package com.comic.pojo;

public class TbFavorite {
    private Integer favoriteid;

    private Integer userid;

    private Integer comicid;

    private String favortime;

    public Integer getFavoriteid() {
        return favoriteid;
    }

    public void setFavoriteid(Integer favoriteid) {
        this.favoriteid = favoriteid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getComicid() {
        return comicid;
    }

    public void setComicid(Integer comicid) {
        this.comicid = comicid;
    }

    public String getFavortime() {
        return favortime;
    }

    public void setFavortime(String favortime) {
        this.favortime = favortime == null ? null : favortime.trim();
    }
}