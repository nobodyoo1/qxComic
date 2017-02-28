package com.comic.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.comic.bean.MyUtils;
import com.comic.pojo.TbUser;
import com.comic.service.UserService;
import com.comic.utils.ComicUtils;

@Controller
public class RegisterController {
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	private static Logger logger = Logger.getLogger(RegisterController.class);
	/**
	 * 用户注册controller
	 * @throws IOException 
	 * 
	 */
	@RequestMapping("/register")
	public void doRegister(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		TbUser tbUser= new TbUser();
		Map<String,Object> map = new HashMap<String, Object>();
		String userName = request.getParameter("username");
		String userPwd = request.getParameter("password");
		//String userMail=request.getParameter("email");
		tbUser.setUsername(userName);
		tbUser.setUserpwd(ComicUtils.getMD5(userPwd));
		tbUser.setUsermail("xxx@xxx.com");
		tbUser.setUsertype(0);
		tbUser.setUserregtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		tbUser.setUserimage("头像/" + MyUtils.getRandomImagePath());
		int userId=userService.registerUser(tbUser);
		
		String flag="failure";
		String ErrorMsg="注册失败,用户名重复";
		if(userId>0){
			flag="success";
			MyUtils.addPrefixforUser(tbUser);
			map.put(flag,tbUser);
			logger.info(userName + " : 注册成功 : " + (new Date()));
		}
		else {
			map.put(flag, ErrorMsg);
			logger.info(userName + " : 注册失败 : " + (new Date()));
		}
		String jsonStr = JSON.toJSONString(map);
		
		MyUtils.writeJsonStr(response, jsonStr);
	}
	
}
