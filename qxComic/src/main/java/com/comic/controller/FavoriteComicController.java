package com.comic.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.comic.bean.MyConstants;
import com.comic.bean.MyUtils;
import com.comic.pojo.TbComic;
import com.comic.pojo.TbFavorite;
import com.comic.service.FavoriteComicService;

@Controller
public class FavoriteComicController {
	@Autowired
	private FavoriteComicService favoriteComicService;
	
	private static Logger logger = Logger.getLogger(FavoriteComicController.class);
	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/mark")
	public void collectComic(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		Map<String, String> map= new HashMap<String, String>();
		String userIdStr = request.getParameter("userId");
		String comicIdStr = request.getParameter("comicId");
		Integer userId =Integer.valueOf(userIdStr);
		Integer comicId =Integer.valueOf(comicIdStr);
		TbFavorite favorite =new TbFavorite();
		favorite.setComicid(comicId);
		favorite.setUserid(userId);
		favorite.setFavortime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		String flag="failure";
		
		if(favoriteComicService.comicCollect(favorite)){
			flag="success";
			map.put(flag, "收藏成功");
			 
		}
		else{
			map.put(flag, "收藏失败,您已收藏该漫画");
		}
		logger.info("收藏 comicId:"+ comicId + " by userId:" + userId + "-" +  map.keySet().toArray()[0] + "-" + (new Date()));
		String jsonStr = JSON.toJSONString(map);
		MyUtils.writeJsonStr(response, jsonStr);
	}
	@RequestMapping("/favorprivate")
	public void getFavoritComic(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		
		Map<String, Object> map =new HashMap<String, Object>();
		String flag ="failure";
		String userIdStr = request.getParameter("userId");
		String pageStr=request.getParameter("page");
		Integer userId = Integer.valueOf(userIdStr);
		Integer page = Integer.valueOf(pageStr);
		List<TbComic> list = favoriteComicService.findFavorComicByUID(userId,page);
		
		if(list.size()>0){
			flag="success";
			map.put(flag, list);
		}
		else map.put(flag, "收藏查询失败");
		logger.info("查询收藏   by userId:" + userId + "-" +  map.keySet().toArray()[0] + "-" + (new Date()));
		String jsonStr = JSON.toJSONString(map);
		MyUtils.writeJsonStr(response, jsonStr);
		
	}
	@RequestMapping("/favor")
	public void getMostFavor(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		String pageStr=request.getParameter("page");
		Integer page = Integer.valueOf(pageStr);
		List<TbComic> list=favoriteComicService.getMostFavorite();
		MyUtils.addPrefixforComics(list);
		list= MyUtils.selectByPage(list, page, MyConstants.ConsType.COMICS);
		
		/*不良代码，与前端折中*/
		Map<String,List<TbComic>> map = new HashMap<>();
		map.put(MyConstants.SUC_FLAG, list);
		logger.info("收藏最多信息查询:" + "-" + map.keySet().toArray()[0] + "-" + (new Date()));
		String jsonStr = JSON.toJSONString(map);
		MyUtils.writeJsonStr(response, jsonStr);
	}
}
