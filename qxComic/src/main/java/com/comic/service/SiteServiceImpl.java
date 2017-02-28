package com.comic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comic.mapper.TbSiteMapper;
import com.comic.pojo.TbSite;
import com.comic.pojo.TbSiteExample;

@Service("siteService")
public class SiteServiceImpl implements SiteService {
	
	@Autowired
	private TbSiteMapper siteDao;

	@Override
	public TbSite getSite(Integer siteId) {
		TbSite site = siteDao.selectByPrimaryKey(siteId);
		return site;
	}

	@Override
	public List<TbSite> getSites() {
		return siteDao.selectByExample(new TbSiteExample());
	}
}
