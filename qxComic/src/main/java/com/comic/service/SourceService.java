package com.comic.service;

import java.util.List;

import com.comic.pojo.TbEpisode;

public interface SourceService {

	List<TbEpisode> findEpisode(Integer comicId,Integer siteId);
}
