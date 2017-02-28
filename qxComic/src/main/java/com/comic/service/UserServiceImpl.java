package com.comic.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comic.mapper.TbUserMapper;
import com.comic.pojo.TbUser;
import com.comic.pojo.TbUserExample;
import com.comic.pojo.TbUserExample.Criteria;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	/*@Resource(name="TbUserMapper")*/
	@Autowired
	private TbUserMapper userDao;

	public TbUser findUser(TbUser user) {
		TbUserExample userExample = new TbUserExample();
		Criteria userCriteria = userExample.createCriteria();
		userCriteria.andUsernameEqualTo(user.getUsername());
		userCriteria.andUserpwdEqualTo(user.getUserpwd());
		List<TbUser> userList = userDao.selectByExample(userExample);
		return userList.size() == 0 ? null : userList.get(0);
	}
	
	public TbUser findUserByToken(TbUser user){
		TbUserExample userExample = new TbUserExample();
		Criteria userCriteria = userExample.createCriteria();
		userCriteria.andUsertypeEqualTo(user.getUsertype());
		userCriteria.andUsertokenEqualTo(user.getUsertoken());
		List<TbUser> userList = userDao.selectByExample(userExample);
		if(userList.size() > 0){
			return userList.get(0);
		}
		else{
			userDao.insertSelective(user);
			return user;
		}
	}

	public int registerUser(TbUser user) {
		TbUserExample userExample = new TbUserExample();
		Criteria criteria= userExample.createCriteria();
		criteria.andUsernameEqualTo(user.getUsername());
		if(userDao.selectByExample(userExample).size()>0){
			return 0;
		}
		else return userDao.insert(user);
			
		
		
		
	}
	
}
