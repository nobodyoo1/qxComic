package com.comic.service;

import com.comic.pojo.TbUser;

public interface UserService {

	/**
	 * 取出用户实体
	 * @param user 将要查询的用户实体类，需要有用户名和密码字段
	 */
	TbUser findUser(TbUser user);
	TbUser findUserByToken(TbUser user);
	int registerUser(TbUser user);
}
