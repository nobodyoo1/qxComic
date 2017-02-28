package com.comic.service;

import java.util.List;
import java.util.Map;

import com.comic.pojo.*;

public interface ComicClassSerivce {
	List<TbComic> findComicByClassId(Integer classId);
	List<TbClass> findAllComicClass();
	Map<String,Object> findSingleComic(Integer comicId);
}
