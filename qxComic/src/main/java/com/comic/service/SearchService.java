package com.comic.service;

import java.util.List;

import com.comic.pojo.TbComic;

public interface SearchService {

	List<TbComic> SearchComic(String word);
}
