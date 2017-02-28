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
import com.comic.pojo.TbComic;
import com.comic.pojo.TbHistory;
import com.comic.service.HistoryService;

@Controller
public class HistoryController {
	
	@Autowired
	@Qualifier("hisrotyService")
	private HistoryService historyService;

	private static Logger logger = Logger.getLogger(HotController.class);
	
	@RequestMapping("/historyprivate")
	public void doHistory(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		Map<String,Object> map = new HashMap<String, Object>();
		Integer userId = null;
		Integer page;
		
		try {
			userId = Integer.parseInt(request.getParameter("userId"));
			page = Integer.parseInt(request.getParameter("page"));
			userId.intValue();
			List<TbComic> comics = historyService.getHistory(userId,page);
			if(comics.size() == 0 && page != 1){
				map.put(MyConstants.FAIL_FLAG, "没有更多了");
			}
			else{
				map.put(MyConstants.SUC_FLAG, comics);
			}
		} catch (NumberFormatException | NullPointerException e) {
			map.put(MyConstants.FAIL_FLAG, "参数不完整或有错");
		}
		finally {
			logger.info("个人历史  by userId:" + userId + "-" + map.keySet().toArray()[0] + "-" + (new Date()));
			String jsonStr = JSON.toJSONString(map);
			MyUtils.writeJsonStr(response, jsonStr);
		}
		
	}
	
	@RequestMapping("/startReading")
	public void doStart(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Map<String,Object> map = new HashMap<String, Object>();
		Integer userId = null;
		Integer comicId = null;
		Integer siteId = null;
		String result = null;
		try {
			userId = Integer.parseInt(request.getParameter("userId"));
			comicId = Integer.parseInt(request.getParameter("comicId"));
			siteId = Integer.parseInt(request.getParameter("siteId"));
			result = historyService.getLocation(comicId, userId, siteId);
			if(result == null){
				map.put(MyConstants.FAIL_FLAG, "发生了未知错误");
			}
			else{
				map.put(MyConstants.SUC_FLAG, result);
			}
		} catch (NumberFormatException e) {
			map.put(MyConstants.FAIL_FLAG, "参数不完整或有错");
		}
		finally {
			logger.info("开始阅读 by " + userId + "& comicId:" + comicId + "-" + map.keySet().toArray()[0] + "-" + (new Date()));
			String jsonStr = JSON.toJSONString(map);
			MyUtils.writeJsonStr(response, jsonStr);
		}
	}
	
}
