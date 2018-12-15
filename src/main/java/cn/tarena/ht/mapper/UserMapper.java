package cn.tarena.ht.mapper;

import java.util.List;

import cn.tarena.ht.pojo.UserTable;


public interface UserMapper {
	
	List<UserTable> selectAllUser();
	
	int insertOneUser(UserTable user);
	
	UserTable selectByUserName(String name);


}
