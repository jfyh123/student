package cn.tarena.ht.mapper;

import java.util.List;

import cn.tarena.ht.pojo.Topic;

public interface TopicMapper {

	List<Topic> showCourseTopic(Integer cid);

	int  updateTopicSum(Integer tid);

	int addCourseTopic(Topic topic);

	List<Topic> showCourseTeacherTopic(Integer cid);

}
