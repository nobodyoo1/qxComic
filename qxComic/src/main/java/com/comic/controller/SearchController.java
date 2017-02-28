package com.comic.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.comic.bean.MyUtils;
import com.comic.pojo.TbComic;
import com.comic.service.SearchService;

@Controller
public class SearchController {

	@Autowired
	@Qualifier("searchService")
	private SearchService searchService;
	
	private static Logger logger = Logger.getLogger(EpisodeController.class);
	
	@RequestMapping("/search")
	public void doSearch(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String word = request.getParameter("word");
		word = MyUtils.transcodeToUTF_8(word);
		List<TbComic> comics = searchService.SearchComic(word);
		logger.info("搜索  by word:" + word + "-" + (new Date()));
		String jsonStr = JSON.toJSONString(comics);
		MyUtils.writeJsonStr(response, jsonStr);
		return;
	}
}
