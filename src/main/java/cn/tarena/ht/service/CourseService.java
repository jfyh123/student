package cn.tarena.ht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.CourseMapper;
import cn.tarena.ht.mapper.UserMapper;
import cn.tarena.ht.pojo.Course;
import cn.tarena.ht.pojo.UserTable;
import cn.tarena.ht.result.SelectAllCourseResult;

@Service
public class CourseService {
	@Autowired
	private CourseMapper coursMapper;


	public List<SelectAllCourseResult> selectAllCourse() {
		return coursMapper.selectAllCourse();
	}
}
