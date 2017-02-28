package com.comic.service;

import java.util.List;

import com.comic.pojo.*;
public interface ComicSourceService {
	
	List<TbSource> findComicSourceInfo(Integer comicId);
}
