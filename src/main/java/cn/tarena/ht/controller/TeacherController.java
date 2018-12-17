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
import cn.tarena.ht.pojo.UserTable;
import cn.tarena.ht.result.CommentsResult;
import cn.tarena.ht.result.ShowCourseResult;
import cn.tarena.ht.service.CourseService;
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
	 * 列出学生已选课程
	 * @author luojiayng
	 * */
	@RequestMapping(value = "/addCourseTopic",produces = "application/json;charset=utf-8")
	public ModelAndView addCourseTopic(HttpServletRequest request,HttpSession session) {
		UserTable get=(UserTable) session.getAttribute("user");
		ModelAndView mav=new ModelAndView();
		 List<Course> list=courseService.showCourseTeacher(get.getUtid());
	    	mav.addObject("courselist", list);
	    	mav.setViewName("select_title");
		return mav;
	}
	
	
	/**
	 * 列出老师的留言
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
	 * 列出老师的留言
	 * @author luojiayng
	 * */
	@RequestMapping(value = "/updateComment",produces = "application/json;charset=utf-8")
	public void updateComment(HttpServletRequest request,HttpSession session,Integer lcid) {
		UserTable get=(UserTable) session.getAttribute("user");
		int i=leaveCommentsService.updateComment(lcid);
	}
	
	
	
	

}
