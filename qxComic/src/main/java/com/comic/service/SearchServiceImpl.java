package com.comic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comic.bean.MyUtils;
import com.comic.mapper.TbComicMapper;
import com.comic.pojo.TbComic;
import com.comic.pojo.TbComicExample;

@Service("searchService")
public class SearchServiceImpl implements SearchService{

	@Autowired
	private TbComicMapper comicDao;
	
	@Override
	public List<TbComic> SearchComic(String word) {
		List<TbComic> comics1 = new ArrayList<>();
		List<TbComic> comics2 = new ArrayList<>();
		List<TbComic> comics3 = new ArrayList<>();
		if(word.equals("") || word == null){
			return comics1;
		}
		List<TbComic> allComics = comicDao.selectByExample(new TbComicExample());
		String[] words = word.trim().split(" ");
		for(String aWord : words){
			for(TbComic aComic : allComics){
				if(aComic.getComicname().equalsIgnoreCase(aWord)){
					comics1.add(aComic);
				}else if(aComic.getComicname().contains(aWord)){
					comics2.add(aComic);
				}else if(aWord.contains(aComic.getComicname())){
					comics3.add(aComic);
				}
			}
		}
		comics1.addAll(comics2);
		comics1.addAll(comics3);
		MyUtils.addPrefixforComics(comics1);
		return comics1;
	}

}
