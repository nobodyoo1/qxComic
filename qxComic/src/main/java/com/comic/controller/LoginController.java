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
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.comic.bean.MyUtils;
import com.comic.pojo.TbUser;
import com.comic.service.UserService;
import com.comic.utils.ComicUtils;

@Controller
public class LoginController {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	private static Logger logger = Logger.getLogger(LoginController.class);

	/**
	 * 如果登录成功则返回完成的user对象的json字符串，否则返回空字符串
	 * @param userName 用户名
	 * @param userPwd 未加密的用户密码
	 * @param response http响应
	 * @throws IOException
	 */
	@RequestMapping("/login")
	public void doLogin(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		Map<String,Object> map = new HashMap<String, Object>();
		TbUser user = new TbUser();
		Integer userType = Integer.parseInt(request.getParameter("usertype").trim());
		if(userType > 0){
			String userToken = request.getParameter("usertoken");
			user.setUsername(ComicUtils.getMD5(userToken).substring(0, userToken.length() / 4));
			user.setUserpwd(ComicUtils.getMD5(userToken));
			user.setUsertoken(userToken);
			user.setUsertype(userType);
			user.setUserregtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			user.setUserimage("头像/" + MyUtils.getRandomImagePath());
			user = userService.findUserByToken(user);
			MyUtils.addPrefixforUser(user);
			map.put("success", user);
			logger.info("用户  "+user.getUsername()+" 登录成功 - "+(new Date()));
			String jsonStr = JSON.toJSONString(map);
			MyUtils.writeJsonStr(response, jsonStr);
			return;
		}
		
		String userName = request.getParameter("username");
		String userPwd = request.getParameter("password");
		if(userName == null || userPwd == null){
			map.put("failure", "登录信息不完整");
			logger.info("登录信息不完整");
			return;
		}
		
		user.setUsername(userName);
		user.setUserpwd(ComicUtils.getMD5(userPwd));
		TbUser foundUser = userService.findUser(user);
		
		if(foundUser==null){
			map.put("failure", "用户名或密码错误");
			logger.info("用户  "+userName+" 登录失败 - 用户名或密码错误 - "+(new Date()));
		}
		else
		{
			MyUtils.addPrefixforUser(foundUser);
			map.put("success", foundUser);
			logger.info("用户  "+userName+" 登录成功 - "+(new Date()));
		}
		String jsonStr = JSON.toJSONString(map);
		
		response.setHeader("Content-type", "text/html;charset=UTF-8"); 
		response.setCharacterEncoding("UTF-8"); 
		PrintWriter out = response.getWriter();
		out.write(jsonStr);
		out.flush();
		out.close();
		return;
	}
}
