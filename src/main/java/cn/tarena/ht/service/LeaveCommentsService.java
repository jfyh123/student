package cn.tarena.ht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.LeaveCommentsMapper;
import cn.tarena.ht.mapper.UserMapper;
import cn.tarena.ht.pojo.UserTable;

@Service
public class LeaveCommentsService {
	@Autowired
	private LeaveCommentsMapper leaveCommentsMapper;

	public int InsertComments(Integer utid, Integer tid, String message) {
		return leaveCommentsMapper.InsertComments(utid,tid,message);
	}
	

}
