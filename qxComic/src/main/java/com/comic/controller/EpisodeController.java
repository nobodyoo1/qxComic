package com.comic.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.comic.bean.MyConstants;
import com.comic.bean.MyUtils;
import com.comic.pojo.TbPicture;
import com.comic.service.EpisodeService;

@Controller
public class EpisodeController {

	@Autowired
	@Qualifier("episodeService")
	private EpisodeService episodeService;
	
	private static Logger logger = Logger.getLogger(EpisodeController.class);
	
	@RequestMapping("/episode")
	public void doPictures(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Map<String,Object> map = new HashMap<String, Object>();
		Integer episodeId = null;
		Integer page;
		Integer userId;
		try {
			episodeId = Integer.parseInt(request.getParameter("episodeId"));
			userId = Integer.parseInt(request.getParameter("userId"));
			try {
				page = Integer.parseInt(request.getParameter("page"));
			} catch (NumberFormatException e) {
				page = null;
			}
			List<TbPicture> pics = episodeService.getPics(episodeId, page, userId);
			if(pics.size() == 0){
				map.put(MyConstants.FAIL_FLAG, "参数错误查询失败");
			}
			else{
				map.put(MyConstants.SUC_FLAG, pics);
			}
		} catch (NumberFormatException e) {
			map.put(MyConstants.FAIL_FLAG, "参数错误查询失败");
		}
		logger.info("获取图片信息  by episodeId:" + episodeId + "-" +  map.keySet().toArray()[0] + "-" + (new Date()));
		String jsonStr = JSON.toJSONString(map);
		MyUtils.writeJsonStr(response, jsonStr);
		return;
	}
	
	@RequestMapping("/next")
	public void doNext(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Integer episodeId = null;
		try {
			episodeId = Integer.parseInt(request.getParameter("episodeId"));
			episodeId = episodeService.getNext(episodeId);
		} catch (NumberFormatException e) {
			episodeId = 0;
		}
		if(episodeId != 0){
			logger.info("获取下一集  by episodeId:" + (episodeId-1) + "-" + (new Date()));
		}
		else{
			logger.info("获取下一集失败 by episodeId:" + (episodeId-1) + "-" + (new Date()));
		}
		String jsonStr = JSON.toJSONString(episodeId);
		MyUtils.writeJsonStr(response, jsonStr);
		return;
	}
}
