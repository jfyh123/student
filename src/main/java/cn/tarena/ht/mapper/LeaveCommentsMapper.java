package cn.tarena.ht.mapper;

import org.apache.ibatis.annotations.Param;

public interface LeaveCommentsMapper {

	int InsertComments(@Param("utid") Integer utid, @Param("tid") Integer tid,@Param("message")  String message);

}
