package com.comic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comic.mapper.TbSiteMapper;
import com.comic.mapper.TbSourceMapper;
import com.comic.pojo.TbSource;
import com.comic.pojo.TbSourceExample;
import com.comic.pojo.TbSourceExample.Criteria;
@Service
public class ComicSourceServiceImpl implements ComicSourceService {
		
	@Autowired
	private TbSourceMapper mapper;
	public List<TbSource> findComicSourceInfo(Integer comicId) {
		TbSourceExample sourceExample =new TbSourceExample();
		Criteria criteria =sourceExample.createCriteria();
		criteria.andComicidEqualTo(comicId);
		List<TbSource> list= mapper.selectByExample(sourceExample);
		
		
		return list;
	}
	
}
