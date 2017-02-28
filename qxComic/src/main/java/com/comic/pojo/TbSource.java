package com.comic.pojo;

public class TbSource {
    private Integer sourceid;

    private Integer comicid;

    private Integer siteid;

	public Integer getSourceid() {
        return sourceid;
    }

    public void setSourceid(Integer sourceid) {
        this.sourceid = sourceid;
    }

    public Integer getComicid() {
        return comicid;
    }

    public void setComicid(Integer comicid) {
        this.comicid = comicid;
    }

    public Integer getSiteid() {
        return siteid;
    }

    public void setSiteid(Integer siteid) {
        this.siteid = siteid;
    }

	public TbSource(Integer comicid, Integer siteid) {
		super();
		this.comicid = comicid;
		this.siteid = siteid;
	}

	public TbSource() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}