package com.comic.service;

import java.util.List;

import com.comic.pojo.*;
public interface FavoriteComicService {
	
	List<TbComic> findFavorComicByUID(Integer userId,Integer page);
	boolean comicCollect(TbFavorite favorite);
	List<TbComic> getMostFavorite();
}
