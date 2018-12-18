package cn.tarena.ht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.TopicMapper;
import cn.tarena.ht.mapper.UserMapper;
import cn.tarena.ht.pojo.Topic;
import cn.tarena.ht.pojo.UserTable;

@Service
public class TopicService {
	@Autowired
	private TopicMapper topicMapper;

	public List<Topic> showCourseTopic(Integer cid) {
		return topicMapper.showCourseTopic(cid);
	}

	public int updateTopicSum(Integer tid) {
		return topicMapper.updateTopicSum(tid);
	}

	public int addCourseTopic(Topic topic) {
		return topicMapper.addCourseTopic(topic);
	}

	public List<Topic> showCourseTeacherTopic(Integer cid) {
		// TODO Auto-generated method stub
		return topicMapper.showCourseTeacherTopic(cid);
	}



}
