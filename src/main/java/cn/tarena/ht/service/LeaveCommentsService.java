package cn.tarena.ht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.LeaveCommentsMapper;
import cn.tarena.ht.mapper.UserMapper;
import cn.tarena.ht.pojo.LeaveComments;
import cn.tarena.ht.pojo.UserTable;
import cn.tarena.ht.result.CommentsResult;

@Service
public class LeaveCommentsService {
	@Autowired
	private LeaveCommentsMapper leaveCommentsMapper;

	public int InsertComments(Integer utid, Integer tid, String message) {
		return leaveCommentsMapper.InsertComments(utid,tid,message);
	}

	public List<CommentsResult> showComment(Integer utid) {
		return leaveCommentsMapper.showComment(utid);
	}

	public int updateComment(Integer lcid) {
		// TODO Auto-generated method stub
		return leaveCommentsMapper.updateComment(lcid);
	}
	

}
