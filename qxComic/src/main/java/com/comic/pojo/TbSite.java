package com.comic.pojo;

public class TbSite {
    private Integer siteid;

    private String sitedomain;

    private String sitename;

    public Integer getSiteid() {
        return siteid;
    }

    public void setSiteid(Integer siteid) {
        this.siteid = siteid;
    }

    public String getSitedomain() {
        return sitedomain;
    }

    public void setSitedomain(String sitedomain) {
        this.sitedomain = sitedomain == null ? null : sitedomain.trim();
    }

    public String getSitename() {
        return sitename;
    }

    public void setSitename(String sitename) {
        this.sitename = sitename == null ? null : sitename.trim();
    }
}