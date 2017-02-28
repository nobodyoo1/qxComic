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
import com.comic.pojo.TbSite;
import com.comic.service.SiteService;

@Controller
public class SiteController {

	@Autowired
	@Qualifier("siteService")
	private SiteService siteService;
	
	private static Logger logger = Logger.getLogger(SiteController.class);
	
	@RequestMapping("/site")
	public void doSite(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Map<String,Object> map = new HashMap<String, Object>();
		Integer siteId = null;
		try {
			siteId = Integer.parseInt(request.getParameter("siteId"));
			TbSite site = siteService.getSite(siteId);
			if(site == null){
				map.put(MyConstants.FAIL_FLAG, "参数错误查询失败");
			}
			else{
				map.put(MyConstants.SUC_FLAG, site);
			}
		} catch (NumberFormatException e) {
			map.put(MyConstants.FAIL_FLAG, "参数错误查询失败");
		}
		logger.info("站点信息  siteId:" + siteId + "-" + map.keySet().toArray()[0] + "-" + (new Date()));
		String jsonStr = JSON.toJSONString(map);
		MyUtils.writeJsonStr(response, jsonStr);
		return;
	}
	
	@RequestMapping("/sites")
	public void doSites(HttpServletRequest request,HttpServletResponse response) throws IOException{
		List<TbSite> sites = siteService.getSites();
		logger.info("全部站点信息  " + "- success -" + (new Date()));
		String jsonStr = JSON.toJSONString(sites);
		MyUtils.writeJsonStr(response, jsonStr);
		return;
	}
}
