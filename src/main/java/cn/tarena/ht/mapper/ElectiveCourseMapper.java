package cn.tarena.ht.mapper;

import org.apache.ibatis.annotations.Param;

public interface ElectiveCourseMapper {

	int InsertElectiveCourse(@Param(value="cid") Integer cid, @Param(value="utid") Integer utid);

}
