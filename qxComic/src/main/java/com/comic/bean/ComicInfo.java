package com.comic.bean;

import java.util.List;

public class ComicInfo {

	private String comic_name;
	private String brief_introduction;
	private String comic_auth;
	private String status;
	private List<String> classify;
	private String hot;
	public String getComic_name() {
		return comic_name;
	}
	public void setComic_name(String comic_name) {
		this.comic_name = comic_name;
	}
	public String getBrief_introduction() {
		return brief_introduction;
	}
	public void setBrief_introduction(String brief_introduction) {
		this.brief_introduction = brief_introduction;
	}
	public String getComic_auth() {
		return comic_auth;
	}
	public void setComic_auth(String comic_auth) {
		this.comic_auth = comic_auth;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<String> getClassify() {
		return classify;
	}
	public void setClassify(List<String> classify) {
		this.classify = classify;
	}
	public String getHot() {
		return hot;
	}
	public void setHot(String hot) {
		this.hot = hot;
	}
	@Override
	public String toString() {
		return "ComicInfo [comic_name=" + comic_name + ", comic_auth=" + comic_auth + ", classify=" + classify + "]";
	}
	
}
