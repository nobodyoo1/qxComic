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
import com.comic.pojo.TbEpisode;
import com.comic.service.SourceService;

@Controller
public class SourceController {

	@Autowired
	@Qualifier("sourceService")
	private SourceService sourceService;
	
	private static Logger logger = Logger.getLogger(SourceController.class);
	
	@RequestMapping("/source")
	public void doSource(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Map<String,Object> map = new HashMap<String, Object>();
		Integer comicId = null;
		Integer siteId = null;
		try {
			comicId = Integer.parseInt(request.getParameter("comicId"));
			siteId = Integer.parseInt(request.getParameter("siteId"));
			List<TbEpisode> episodes = sourceService.findEpisode(comicId,siteId);
			if(episodes.size() == 0){
				map.put(MyConstants.FAIL_FLAG, "参数错误查询失败");
			}
			else{
				map.put(MyConstants.SUC_FLAG, episodes);
			}
		} catch (NumberFormatException e) {
			map.put(MyConstants.FAIL_FLAG, "参数错误查询失败");
		}
		logger.info("集信息  comicId:" + comicId + "-" + map.keySet().toArray()[0] + "-" + (new Date()));
			String jsonStr = JSON.toJSONString(map);
			MyUtils.writeJsonStr(response, jsonStr);
		return;
	}
}
