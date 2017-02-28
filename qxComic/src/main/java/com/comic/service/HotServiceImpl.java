package com.comic.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comic.bean.MyConstants;
import com.comic.bean.MyUtils;
import com.comic.mapper.TbComicMapper;
import com.comic.mapper.TbHistoryMapper;
import com.comic.pojo.TbComic;
import com.comic.pojo.TbComicExample;
import com.comic.pojo.TbHistory;
import com.comic.pojo.TbHistoryExample;
import com.comic.service.HotServiceImpl.CountMap;

@Service("hotService")
public class HotServiceImpl implements HotService {
	
	@Autowired
	private TbHistoryMapper historyDao;
	@Autowired
	private TbComicMapper comicDao;

	public List<TbComic> getHotComic(Integer page) {
		TbHistoryExample historyExample = new TbHistoryExample();
		List<TbHistory>	hlist = historyDao.selectByExample(historyExample);
		
		TbComicExample comicExample = new TbComicExample();
		List<TbComic> clist = comicDao.selectByExample(comicExample);
		
		CountMap[] maps = new CountMap[clist.size()];
		Map<Integer,Integer> sortmap = new HashMap<Integer,Integer>(clist.size());
		int i = 0;
		for(; i < maps.length; i++){
			maps[i] = new CountMap();
			maps[i].setComic(clist.get(i));
			sortmap.put(clist.get(i).getComicid(), 0);
		}
		int oldcount;
		for(TbHistory h : hlist){
			oldcount = sortmap.get(h.getComicid());
			sortmap.replace(h.getComicid(), ++oldcount);
		}
		
		for(i = 0; i < maps.length; i++){
			maps[i].setCount(sortmap.get(maps[i].comic.getComicid()));
		}
		Arrays.sort(maps);
		
		List<TbComic> result = new ArrayList<TbComic>();
		CountMap[] TempResult = MyUtils.selectByPage(maps, page, MyConstants.ConsType.COMICS);
		for(i = 0; i < TempResult.length ; i++){
			result.add(TempResult[i].comic);
		}
		MyUtils.addPrefixforComics(result);
		return result;
	}
	
	class CountMap implements Comparable<CountMap>{
		private String[] names = {"海贼王 143 ","旋风管家 38","妖精的尾巴 267"};
		private TbComic comic;
		private int count;
		public void setComic(TbComic comicid) {
			this.comic = comicid;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public int compareTo(CountMap other) {
			int id1 = this.comic.getComicid();//保证指定指定的三部漫画位于第一行
			int id2 = other.comic.getComicid();
			if(id1 == 267)
				return -1;
			if(id2 == 267)
				return 1;
			if(id1 == 143)
				return -1;
			if(id2 == 143)
				return 1;
			if(id1 == 38)
				return -1;
			if(id2 == 38)
				return 1;
			
			int pri = this.count - other.count;
			return -(pri != 0 ? pri : (this.comic.getComicid() - other.comic.getComicid()));//保证降序
		}
		
	}
}
