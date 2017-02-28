package com.comic.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.comic.bean.MyUtils;
import com.comic.pojo.TbSource;
import com.comic.service.ComicSourceService;

@Controller
public class ComicSourceController {
	@Autowired 
	private ComicSourceService comicSourceService;
	
	private static Logger logger = Logger.getLogger(ComicSourceController.class);
	
	@RequestMapping("/comic")
	public void getComicSourceServiceInfo(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		Map<String, Object> map =new HashMap<String, Object>();
		String flag ="failure";
		String comicIdStr = request.getParameter("comicId");
		Integer comicId = Integer.valueOf(comicIdStr);
		List<TbSource> list = comicSourceService.findComicSourceInfo(comicId);
		if(list.size()>0){
			flag="success";
			map.put(flag, list);
		}
		else{
			map.put(flag,"获取漫画源信息失败");
		}
		logger.info("获取漫画源 by comicId: " + comicId + map.keySet().toArray()[0] + "-" + (new Date()));
		String jsonStr = JSON.toJSONString(map);
		MyUtils.writeJsonStr(response, jsonStr);
	}
	
	
}
