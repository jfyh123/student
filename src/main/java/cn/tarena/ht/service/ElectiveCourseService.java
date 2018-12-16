package cn.tarena.ht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.ElectiveCourseMapper;
import cn.tarena.ht.mapper.UserMapper;
import cn.tarena.ht.pojo.UserTable;
import cn.tarena.ht.result.ShowCourseResult;

@Service
public class ElectiveCourseService {
	@Autowired
	private ElectiveCourseMapper electiveCourseMapper;

	/**
	 * 选择课程
	 * @author LuoJiaying
	 * */
	public int InsertElectiveCourse(Integer cid, Integer utid) {
		// TODO Auto-generated method stub
		return electiveCourseMapper.InsertElectiveCourse(cid,utid);
	}

	/*
	 * 显示学生已选课程
	 * @author LuoJiaying
	 * **/
	public List<ShowCourseResult> showCourse(Integer utid) {
		return electiveCourseMapper.showCourse(utid);
	}
}
