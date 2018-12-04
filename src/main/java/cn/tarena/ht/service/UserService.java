package cn.tarena.ht.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.UserMapper;
import cn.tarena.ht.pojo.User;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;

	
	public List<User> selectList(){
		List<User> list=userMapper.selectList();
		return  list;
	}

}
