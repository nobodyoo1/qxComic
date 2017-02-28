package com.comic.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comic.bean.MyConstants;
import com.comic.bean.MyUtils;
import com.comic.mapper.TbComicMapper;
import com.comic.mapper.TbFavoriteMapper;
import com.comic.pojo.TbComic;
import com.comic.pojo.TbComicExample;
import com.comic.pojo.TbFavorite;
import com.comic.pojo.TbFavoriteExample;
import com.comic.pojo.TbFavoriteExample.Criteria;

@Service
public class FavoriteComicServiceImpl implements FavoriteComicService {
	@Autowired
	private TbFavoriteMapper favoriteMapper;
	@Autowired
	private TbComicMapper comicMapper;
	public List<TbComic> findFavorComicByUID(Integer userId,Integer page) {
		List<TbComic> list=new ArrayList<TbComic>();
		List<Integer> cidList = new ArrayList<>();
		TbFavoriteExample favoriteExample = new TbFavoriteExample();
		Criteria faCriteria=favoriteExample.createCriteria();
		faCriteria.andUseridEqualTo(userId);
		List<TbFavorite> tbFavorites=favoriteMapper.selectByExample(favoriteExample);
		Comparator<TbFavorite> comparator = new Comparator<TbFavorite>() {
			public int compare(TbFavorite f1, TbFavorite f2) {
				Date d1 = null;
				Date d2 = null;
				try {
					d1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(f1.getFavortime());
					d2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(f2.getFavortime());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return d2.compareTo(d1);
			}
		};
		Collections.sort(tbFavorites, comparator);
		for(TbFavorite favorite : tbFavorites){
			cidList.add(favorite.getComicid());
		}
		cidList = MyUtils.selectByPage(cidList, page, MyConstants.ConsType.COMICS);
		
		if(tbFavorites.size()>0){
			for(Integer cid : cidList){
				list.add(comicMapper.selectByPrimaryKey(cid));
			}
			MyUtils.addPrefixforComics(list);
		}
		return list;
	}

	public boolean comicCollect(TbFavorite favorite) {
		TbFavoriteExample favoriteExample = new TbFavoriteExample();
		Criteria faCriteria=favoriteExample.createCriteria();
		faCriteria.andUseridEqualTo(favorite.getUserid()).andComicidEqualTo(favorite.getComicid());
		List<TbFavorite>  list=favoriteMapper.selectByExample(favoriteExample);
		if(list.size() > 0)
			return false;
		return favoriteMapper.insert(favorite)>0 ? true : false;
	}

	public List<TbComic> getMostFavorite() {
		
		List<TbcomicandFavorite> list = new ArrayList<TbcomicandFavorite>();
		TbComicExample tbComicExample=new TbComicExample();
		com.comic.pojo.TbComicExample.Criteria criteriaTb=tbComicExample.createCriteria();
		List<TbComic> listCo= comicMapper.selectByExample(tbComicExample);
		Iterator<TbComic> iteratorTb=listCo.iterator();
		while(iteratorTb.hasNext()){
			TbcomicandFavorite tbcomicandFavorite =new TbcomicandFavorite();
			tbcomicandFavorite.setComic(iteratorTb.next());
			list.add(tbcomicandFavorite);
		}
		TbFavoriteExample favoriteExample = new TbFavoriteExample();
		int listSize=list.size();
		for(int i=0;i<list.size();i++){
			TbFavoriteExample tbFavoriteExample=new TbFavoriteExample();
			Criteria criteria =tbFavoriteExample.createCriteria();
			criteria.andComicidEqualTo(list.get(i).getComic().getComicid());
			List<TbFavorite> tbFavorites = favoriteMapper.selectByExample(tbFavoriteExample);
			list.get(i).setNum((double)tbFavorites.size());
			
		}
		Collections.reverse(list);
		List<TbComic> listEnd=new ArrayList<TbComic>();
		for(int i=0;i<list.size();i++){
			listEnd.add(list.get(i).getComic());
		}
		return listEnd;
	}

	class TbcomicandFavorite implements Comparable{
		private TbComic comic;
		private Double num;
		public TbComic getComic() {
			return comic;
		}
		public void setComic(TbComic comic) {
			this.comic = comic;
		}
		public Double getNum() {
			return num;
		}
		public void setNum(Double num) {
			this.num = num;
		}
		public int compareTo(Object o) {
			TbcomicandFavorite tbcomicandFavorite=(TbcomicandFavorite)o;
			
			return this.num.compareTo(tbcomicandFavorite.getNum());
		}
		
	}

}
