package cn.tarena.ht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.UserMapper;
import cn.tarena.ht.pojo.UserTable;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;

	
	public List<UserTable> selectAllUser(){
		List<UserTable> list=userMapper.selectAllUser();
		return  list;
	}
	
	public int insertOneUser(UserTable user){
		return userMapper.insertOneUser(user);
	}
    
	/**
	 * 用户登录
	 * @author LuoJiaying
	 * */
	public UserTable UserLogin(String name) {
		return userMapper.selectByUserName(name);
	}
	
	/**
	 * 个人信息
	 * @author LuoJiaying
	 * */
	public UserTable Information(int utid) {
		return userMapper.selectById(utid);
	}

}
