package com.comic.service;

import java.util.List;

import com.comic.pojo.TbComic;

public interface HotService {

	List<TbComic> getHotComic(Integer page);
}
