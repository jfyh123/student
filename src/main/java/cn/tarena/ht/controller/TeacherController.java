package cn.tarena.ht.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.tarena.ht.pojo.Course;
import cn.tarena.ht.pojo.LeaveComments;
import cn.tarena.ht.pojo.Topic;
import cn.tarena.ht.pojo.UserTable;
import cn.tarena.ht.result.CommentsResult;
import cn.tarena.ht.result.ShowCourseResult;
import cn.tarena.ht.result.StudentTopic;
import cn.tarena.ht.service.CourseService;
import cn.tarena.ht.service.ElectiveCourseService;
import cn.tarena.ht.service.LeaveCommentsService;
import cn.tarena.ht.service.TopicService;
import cn.tarena.ht.service.UserService;
import cn.tarena.ht.utils.MyTools;
import cn.tarena.ht.utils.Result;
import cn.tarena.ht.utils.ResultConstants;
import cn.tarena.ht.utils.ResultFactory;

@Controller
@RequestMapping("teacher")
public class TeacherController {
	
	@Autowired
	private TopicService topicService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private  LeaveCommentsService leaveCommentsService;
	@Autowired
	private ElectiveCourseService electiveCourseService;
	
	/**
	 * 列出老师的课程
	 * @author luojiayng
	 * */
	@RequestMapping(value = "/showCourseTeacher",produces = "application/json;charset=utf-8")
	public ModelAndView showCourseTeacher(HttpServletRequest request,HttpSession session) {
		UserTable get=(UserTable) session.getAttribute("user");
		ModelAndView mav=new ModelAndView();
		 List<Course> list=courseService.showCourseTeacher(get.getUtid());
	    	mav.addObject("courselist", list);
	    	mav.setViewName("select_title");
		return mav;
	}
	
	/**
	 * 添加课程选题
	 * @author luojiayng
	 * */
	@RequestMapping(value = "/addCourseTopic",produces = "application/json;charset=utf-8")
	public @ResponseBody Result addCourseTopic(HttpServletRequest request,Topic topic) {
		int i =topicService.addCourseTopic(topic);
	    if(i==1){
	    	 return ResultFactory.generateResult(ResultConstants.SUCCESS_CODE, 
						ResultConstants.SUCCESS_MSG);
	    }else{
	    	 return ResultFactory.generateResult(ResultConstants.ERROR_CODE, 
						ResultConstants.ERROR_MSG);
	    }	   
	}
	
	/**
	 * 查看课程选题
	 * @author luojiayng
	 * */
	@RequestMapping(value = "/showCourseTopic",produces = "application/json;charset=utf-8")
	public ModelAndView showCourseTopic(HttpServletRequest request,Integer cid) {
		ModelAndView mav=new ModelAndView();
		List<Topic> list=topicService.showCourseTeacherTopic(cid);
	    	mav.addObject("topiclist", list);
	    	mav.setViewName("check_select_title");
		return mav;
	}
	
	/**
	 * 查看已经提交选题的信息
	 * @author luojiayng
	 * */
	@RequestMapping(value = "/showSelectTopic",produces = "application/json;charset=utf-8")
	public ModelAndView showSelectTopic(HttpServletRequest request,HttpSession session) {
		ModelAndView mav=new ModelAndView();
		UserTable get=(UserTable) session.getAttribute("user");
		List<StudentTopic> list = electiveCourseService.showSelectTopic(get.getUtid());
	    	mav.setViewName("");
		return mav;
	}
	
	
	
	/**
	 * 老师的留言
	 * @author luojiayng
	 * */
	@RequestMapping(value = "/showComment",produces = "application/json;charset=utf-8")
	public ModelAndView showComment(HttpServletRequest request,HttpSession session) {
		UserTable get=(UserTable) session.getAttribute("user");
		ModelAndView mav=new ModelAndView();
		List<CommentsResult> list=leaveCommentsService.showComment(get.getUtid());
	    	mav.addObject("commentslist", list);
	    	mav.setViewName("t_words");
		return mav;
	}
	
	/**
	 * 老师查阅
	 * @author luojiayng
	 * */
	@RequestMapping(value = "/updateComment",produces = "application/json;charset=utf-8")
	public  @ResponseBody Result updateComment(HttpServletRequest request,Integer lcid) {
		int i=leaveCommentsService.updateComment(lcid);
		 if(i==1){
	    	 return ResultFactory.generateResult(ResultConstants.SUCCESS_CODE, 
						ResultConstants.SUCCESS_MSG);
	    }else{
	    	 return ResultFactory.generateResult(ResultConstants.ERROR_CODE, 
						ResultConstants.ERROR_MSG);
	    }	
	}
	
	
	
	

}
