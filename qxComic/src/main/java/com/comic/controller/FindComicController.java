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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.comic.bean.MyConstants;
import com.comic.bean.MyUtils;
import com.comic.pojo.TbClass;
import com.comic.pojo.TbComic;
import com.comic.pojo.TbUser;
import com.comic.service.ComicClassSerivce;

@Controller
public class FindComicController {
	@Autowired
	private ComicClassSerivce classSerivce;
	
	private static Logger logger = Logger.getLogger(FindComicController.class);
	/**
	 * 根据分类获取漫画处理器
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/class")
	public String getComicByClassId(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		
		TbUser tbUser= new TbUser();
		Map<String,Object> map = new HashMap<String, Object>();
		String classIdStr = request.getParameter("classId");
		String pageStr=request.getParameter("page");
		Integer page=Integer.parseInt(pageStr);
		Integer classId=Integer.parseInt(classIdStr);
		
		if(classId == 32){
			return "forward:/hot";
		}else if(classId == 33){
			return "forward:/favor";
		}
		
		List<TbComic> list=classSerivce.findComicByClassId(classId);
		MyUtils.addPrefixforComics(list);
		list= MyUtils.selectByPage(list, page, MyConstants.ConsType.COMICS);
		String flag="failure";
		String ErrorMsg="查询失败";
		if(list.size()>0){
			flag="success";
			map.put(flag,list);
		}
		else {map.put(flag, ErrorMsg);}
		logger.info("类别 classId:" + classId + "-" + map.keySet().toArray()[0] + "-" + (new Date()));
		String jsonStr = JSON.toJSONString(map);
		MyUtils.writeJsonStr(response, jsonStr);
		
		return null;
	}
	/**
	 * 获取漫画分类处理器
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/classes")
	public void getComicClass(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		
		List<TbClass> list =classSerivce.findAllComicClass();
		
		/*不好的语句，和前端的折中*/
		TbClass hClass = new TbClass();
		hClass.setClassid(list.size()+1);
		hClass.setClassname("最热漫画");
		TbClass fClass = new TbClass();
		fClass.setClassid(list.size()+2);
		fClass.setClassname("收藏最多");
		list.add(0, fClass);
		list.add(0, hClass);
		logger.info("所有类别信息:" + "-" + MyConstants.SUC_FLAG + "-" + (new Date()));
		String jsonStr = JSON.toJSONString(list);
		MyUtils.writeJsonStr(response, jsonStr);
	}
	
	@RequestMapping("/singleComic")
	public void getSingleComic(HttpServletRequest request,HttpServletResponse response) throws IOException{
		int comicId = Integer.parseInt(request.getParameter("comicId"));
		Map<String,Object> map = classSerivce.findSingleComic(comicId);
		
		logger.info("漫画信息 comicId:" + comicId + "-" + MyConstants.SUC_FLAG + "-" + (new Date()));
		String jsonStr = JSON.toJSONString(map);
		MyUtils.writeJsonStr(response, jsonStr);
	}
}
