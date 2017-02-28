package com.comic.pojo;

public class TbHistory {
    private Integer historyid;

    private Integer userid;

    private Integer comicid;

    private String historylocation;

    private String viewtime;

    public Integer getHistoryid() {
        return historyid;
    }

    public void setHistoryid(Integer historyid) {
        this.historyid = historyid;
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

    public String getHistorylocation() {
        return historylocation;
    }

    public void setHistorylocation(String historylocation) {
        this.historylocation = historylocation == null ? null : historylocation.trim();
    }

    public String getViewtime() {
        return viewtime;
    }

    public void setViewtime(String viewtime) {
        this.viewtime = viewtime == null ? null : viewtime.trim();
    }

	@Override
	public String toString() {
		return "TbHistory [historyid=" + historyid + ", userid=" + userid + ", comicid=" + comicid
				+ ", historylocation=" + historylocation + ", viewtime=" + viewtime + "]";
	}
}