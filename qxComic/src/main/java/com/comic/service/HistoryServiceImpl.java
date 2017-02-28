package com.comic.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comic.bean.MyConstants;
import com.comic.bean.MyUtils;
import com.comic.mapper.TbComicMapper;
import com.comic.mapper.TbEpisodeMapper;
import com.comic.mapper.TbHistoryMapper;
import com.comic.mapper.TbSourceMapper;
import com.comic.pojo.TbComic;
import com.comic.pojo.TbComicExample;
import com.comic.pojo.TbEpisode;
import com.comic.pojo.TbEpisodeExample;
import com.comic.pojo.TbFavorite;
import com.comic.pojo.TbHistory;
import com.comic.pojo.TbHistoryExample;
import com.comic.pojo.TbHistoryExample.Criteria;
import com.comic.pojo.TbSource;
import com.comic.pojo.TbSourceExample;

@Service("hisrotyService")
public class HistoryServiceImpl implements HistoryService {
	
	@Autowired
	private TbHistoryMapper historyDao;
	@Autowired
	private TbComicMapper comicDao;
	@Autowired
	private TbEpisodeMapper episodeDao;
	@Autowired
	private TbSourceMapper sourceDao;

	public List<TbComic> getHistory(Integer userId,Integer page) {
		List<Integer> comicIds = new ArrayList<Integer>();
		List<TbComic> clist = new ArrayList<>();
		List<TbHistory>	hlist = null, oldhlist = null;
		
		TbHistoryExample historyExample = new TbHistoryExample();
		Criteria historyCriteria = historyExample.createCriteria();
		historyCriteria.andUseridEqualTo(userId);
		oldhlist = historyDao.selectByExample(historyExample);
		Comparator<TbHistory> comparator = new Comparator<TbHistory>() {
			public int compare(TbHistory h1, TbHistory h2) {
				Date d1 = null;
				Date d2 = null;
				try {
					d1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(h1.getViewtime());
					d2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(h2.getViewtime());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return d2.compareTo(d1);
			}
		};
		Collections.sort(oldhlist, comparator);
		
		hlist = MyUtils.selectByPage(oldhlist, page, MyConstants.ConsType.ITEMS);
		for(TbHistory h : hlist){
			comicIds.add(h.getComicid());
		}
		if(comicIds.size() != 0){
			for(Integer cid : comicIds){
				clist.add(comicDao.selectByPrimaryKey(cid));
			}
			MyUtils.addPrefixforComics(clist);
		}
		return clist;
	}

	@Override
	public String getLocation(Integer comicId, Integer userId,Integer siteId) {
		TbHistoryExample historyExample = new TbHistoryExample();
		historyExample.createCriteria().andComicidEqualTo(comicId);
		List<TbHistory> hisroties = historyDao.selectByExample(historyExample);
		if(hisroties.size() == 0){
			TbSourceExample sourceExample = new TbSourceExample();
			sourceExample.createCriteria().andComicidEqualTo(comicId).andSiteidEqualTo(siteId);
			List<TbSource> sources = sourceDao.selectByExample(sourceExample);
			if(sources.size() == 0)
				return null;
			else{
				TbEpisodeExample episodeExample = new TbEpisodeExample();
				episodeExample.createCriteria().andSourceidEqualTo(sources.get(0).getSourceid());
				List<TbEpisode> episodes = episodeDao.selectByExample(episodeExample);
				Comparator<TbEpisode> comparator = new Comparator<TbEpisode>() {
					public int compare(TbEpisode e1, TbEpisode e2) {
						return e1.getEpisodenum() - e2.getEpisodenum();
					}
				};
				Collections.sort(episodes, comparator);
				TbEpisode episode = episodes.get(0);
				return "" + episode.getEpisodeid() + "#" + episode.getEpisodenum() + "#1#1";
			}
		}
		else{
			return hisroties.get(0).getHistorylocation();
		}
	}

}
