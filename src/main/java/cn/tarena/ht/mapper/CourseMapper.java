package cn.tarena.ht.mapper;

import java.util.List;

import cn.tarena.ht.pojo.Course;
import cn.tarena.ht.result.SelectAllCourseResult;

public interface CourseMapper {

	List<SelectAllCourseResult> selectAllCourse(Integer utid);

	List<Course> showCourseTeacher(Integer utid);

}
