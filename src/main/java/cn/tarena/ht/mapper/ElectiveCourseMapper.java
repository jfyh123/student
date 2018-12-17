package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tarena.ht.pojo.ElectiveCourse;
import cn.tarena.ht.result.CheckCourse;
import cn.tarena.ht.result.ShowCourseResult;

public interface ElectiveCourseMapper {

	int InsertElectiveCourse(@Param(value="cid") Integer cid, @Param(value="utid") Integer utid);

	List<ShowCourseResult> showCourse(Integer utid);

	List<ShowCourseResult> showCourseGrade(Integer utid);

	CheckCourse CheckElectiveCourse(@Param(value="cid") Integer cid, @Param(value="utid") Integer utid);

	int deleteCourse(Integer ecid);

	int selectCourseTopic(@Param("utid")  Integer utid, @Param("ecid")  Integer ecid, 
			@Param("tid") Integer tid, @Param("works") String works);
}
