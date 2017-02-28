package com.comic.service;

import java.util.List;

import com.comic.pojo.TbSite;

public interface SiteService {

	TbSite getSite(Integer siteId);
	List<TbSite> getSites();
}
