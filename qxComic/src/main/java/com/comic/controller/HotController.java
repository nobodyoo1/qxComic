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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.comic.bean.MyConstants;
import com.comic.bean.MyUtils;
import com.comic.pojo.TbComic;
import com.comic.service.HotService;

@Controller
public class HotController {

	@Autowired
	@Qualifier("hotService")
	private HotService hotService;
	
	private static Logger logger = Logger.getLogger(HotController.class);
	
	/**
	 * 返回最热的12部漫画，如果数据不足，不足的部分按照id降序补充
	 * @throws IOException 
	 */
	@RequestMapping("/hot")
	public void doHot(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		Integer page ;
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
			page = null;
		}
		
		List<TbComic> hotComics = hotService.getHotComic(page);
		
		/*不良代码，与前端折中*/
		Map<String,List<TbComic>> map = new HashMap<>();
		map.put(MyConstants.SUC_FLAG, hotComics);
		String jsonStr = JSON.toJSONString(map);
		logger.info("最热漫画信息查询:" + "-" + map.keySet().toArray()[0] + "-" + (new Date()));
		MyUtils.writeJsonStr(response, jsonStr);
		return;
	}
}
