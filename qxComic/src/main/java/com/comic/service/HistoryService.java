package com.comic.service;

import java.util.List;
import java.util.Map;

import com.comic.pojo.TbComic;
import com.comic.pojo.TbHistory;

public interface HistoryService {

	List<TbComic> getHistory(Integer userId,Integer page);
	String getLocation(Integer comicId,Integer userId,Integer siteId);
}
