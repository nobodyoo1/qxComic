package com.comic.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comic.bean.MyUtils;
import com.comic.mapper.TbClassMapper;
import com.comic.mapper.TbComicMapper;
import com.comic.mapper.TbSiteMapper;
import com.comic.mapper.TbSourceMapper;
import com.comic.pojo.TbClass;
import com.comic.pojo.TbClassExample;
import com.comic.pojo.TbComic;
import com.comic.pojo.TbComicExample;
import com.comic.pojo.TbComicExample.Criteria;
import com.comic.pojo.TbSite;
import com.comic.pojo.TbSource;
import com.comic.pojo.TbSourceExample;
@Service
public class ComicClassSerivceImpl implements ComicClassSerivce {
	@Autowired
	private TbComicMapper comicMapper;
	@Autowired
	private TbClassMapper classMapper;
	@Autowired
	private TbSourceMapper sourceMapper;
	@Autowired
	private TbSiteMapper siteMapper;
	/**
	 * ͨ����������ȡ�����������
	 * 
	 */
	public List<TbComic> findComicByClassId(Integer classId) {
		TbComicExample example =new TbComicExample();
		Criteria criteria=example.createCriteria();
		criteria.andClassidEqualTo(classId);
		List<TbComic> list=comicMapper.selectByExample(example);
	
		return list;
	}
	/**
	 * ��ȡ������������
	 */
	public List<TbClass> findAllComicClass() {
		TbClassExample classExample = new TbClassExample();
		List<TbClass> list = classMapper.selectByExample(classExample);
		return list;
	}
	
	public Map<String,Object> findSingleComic(Integer comicId) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<TbSource> sources = null;
		List<TbSite> sites = new ArrayList<>();
		TbComic comic = comicMapper.selectByPrimaryKey(comicId);
		TbClass aclass = classMapper.selectByPrimaryKey(comic.getClassid());
		/*TbSourceExample sourceExample = new TbSourceExample();
		sourceExample.createCriteria().andComicidEqualTo(comicId);
		sources = sourceMapper.selectByExample(sourceExample);
		for(TbSource source : sources){
			sites.add(siteMapper.selectByPrimaryKey(source.getSiteid()));
		}*/
		MyUtils.addPrefixforCimic(comic);
		map.put("comic", comic);
		map.put("classname", aclass.getClassname());
		//map.put("sitesupport", sites);
		return map;
	}

}
