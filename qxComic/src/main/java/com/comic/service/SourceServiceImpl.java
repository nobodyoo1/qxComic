package com.comic.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comic.mapper.TbEpisodeMapper;
import com.comic.mapper.TbSourceMapper;
import com.comic.pojo.TbEpisode;
import com.comic.pojo.TbEpisodeExample;
import com.comic.pojo.TbEpisodeExample.Criteria;
import com.comic.pojo.TbSource;
import com.comic.pojo.TbSourceExample;

@Service("sourceService")
public class SourceServiceImpl implements SourceService {
	
	@Autowired
	private TbEpisodeMapper episodeDao;
	@Autowired
	private TbSourceMapper sourceDao;

	@Override
	public List<TbEpisode> findEpisode(Integer comicId,Integer siteId) {
		TbSourceExample sourceExample = new TbSourceExample();
		com.comic.pojo.TbSourceExample.Criteria sourceCriteria = sourceExample.createCriteria();
		sourceCriteria.andComicidEqualTo(comicId);
		sourceCriteria.andSiteidEqualTo(siteId);
		List<TbSource> sources = sourceDao.selectByExample(sourceExample);
		if(sources.size() == 0){
			return new ArrayList<>();
		}
		TbSource source = sources.get(0);
		
		TbEpisodeExample episodeExample = new TbEpisodeExample();
		Criteria episodeCriteria = episodeExample.createCriteria();
		episodeCriteria.andSourceidEqualTo(source.getSourceid());
		List<TbEpisode> episodes = episodeDao.selectByExample(episodeExample);
		
		Comparator<TbEpisode> comparator = new Comparator<TbEpisode>() {
			public int compare(TbEpisode e1, TbEpisode e2) {
				return e1.getEpisodenum() - e2.getEpisodenum();
			}
		};
		Collections.sort(episodes, comparator);
		
		return episodes;
	}

}
