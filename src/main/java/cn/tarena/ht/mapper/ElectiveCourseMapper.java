package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tarena.ht.result.ShowCourseResult;

public interface ElectiveCourseMapper {

	int InsertElectiveCourse(@Param(value="cid") Integer cid, @Param(value="utid") Integer utid);

	List<ShowCourseResult> showCourse(Integer utid);
}
