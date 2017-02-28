package com.comic.service;

import com.comic.pojo.TbFavorite;

public interface FavoriteService {

	/**
	 * 储存用户收藏
	 */
	Integer addFavorite(TbFavorite favorite);
}
