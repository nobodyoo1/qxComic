package com.comic.service;

import java.util.List;

import com.comic.pojo.TbEpisode;
import com.comic.pojo.TbPicture;

public interface EpisodeService {

	List<TbPicture> getPics(Integer episodeId,Integer page, Integer userId);
	Integer getNext(Integer episodeId);
}
