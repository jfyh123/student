package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import cn.tarena.ht.result.CommentsResult;

public interface LeaveCommentsMapper {

	int InsertComments(@Param("utid") Integer utid, @Param("tid") Integer tid,@Param("message")  String message);

	List<CommentsResult> showComment(Integer utid);

	int updateComment(Integer lcid);

}
