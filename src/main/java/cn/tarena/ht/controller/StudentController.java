package cn.tarena.ht.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.tarena.ht.pojo.Course;
import cn.tarena.ht.pojo.ElectiveCourse;
import cn.tarena.ht.pojo.Topic;
import cn.tarena.ht.pojo.UserTable;
import cn.tarena.ht.result.CheckCourse;
import cn.tarena.ht.result.SelectAllCourseResult;
import cn.tarena.ht.result.ShowCourseResult;
import cn.tarena.ht.service.CourseService;
import cn.tarena.ht.service.ElectiveCourseService;
import cn.tarena.ht.service.TopicService;
import cn.tarena.ht.service.UserService;
import cn.tarena.ht.utils.MyTools;
import cn.tarena.ht.utils.Result;
import cn.tarena.ht.utils.ResultConstants;
import cn.tarena.ht.utils.ResultFactory;

@Controller
@RequestMapping("student")
public class StudentController {
	@Autowired
	private CourseService courseService;
	@Autowired
	private ElectiveCourseService electiveCourseService;
	@Autowired
	private TopicService topicService;
	
	/**
	 * 学生选课
	 * @author luojiayng
	 * */
	@RequestMapping(value = "/electiveCourse",produces = "application/json;charset=utf-8")
	public ModelAndView electiveCourse(HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
	    List<SelectAllCourseResult> list =courseService.selectAllCourse();
		mav.addObject("coursedate", list);
		mav.setViewName("select_subject");
		return mav;
	}
	
	/**
	 * 选择课程
	 * @author luojiayng
	 * */
	//TODO  还有一个数据的校验没有做完
	@RequestMapping(value = "/selectCourse",produces = "application/json;charset=utf-8")
	public @ResponseBody Result  selectCourse(HttpServletRequest request,HttpSession session,String course) {
		if(MyTools.isNullOrEmpty(course))
		{
			return ResultFactory.generateResult(ResultConstants.PARAMETER_CODE, 
					ResultConstants.PARAMETER_MSG);
		}
		UserTable get=(UserTable) session.getAttribute("user");
		List<CheckCourse> list=new ArrayList<CheckCourse>();
		String[] id=course.split(",");
		for(String cid:id){
			//检查这个学生有没有选过这个课
			CheckCourse cc=electiveCourseService.CheckElectiveCourse(Integer.parseInt(cid),get.getUtid());
			if(cc!=null){
				list.add(cc);
			}else{
				electiveCourseService.InsertElectiveCourse(Integer.parseInt(cid),get.getUtid());
			}
		}
		return ResultFactory.generateResult(ResultConstants.SUCCESS_CODE, 
						ResultConstants.SUCCESS_MSG,list);
	}
	
	/**
	 * 列出学生已选课程
	 * @author luojiayng
	 * */
	@RequestMapping(value = "/showCourse",produces = "application/json;charset=utf-8")
	public ModelAndView ShowCourse(HttpServletRequest request,HttpSession session) {
		UserTable get=(UserTable) session.getAttribute("user");
		ModelAndView mav=new ModelAndView();
		 List<ShowCourseResult> list=electiveCourseService.showCourse(get.getUtid());
	    	mav.addObject("courselist", list);
	    	mav.setViewName("index");
		return mav;
	}
	
	/**
	 *退课
	 * @author luojiayng
	 * */
	@RequestMapping(value = "/deleteCourse",produces = "application/json;charset=utf-8")
	public @ResponseBody Result deleteCourse(HttpServletRequest request, String course) {
		String msg="";
		String[] id=course.split(",");
		for(String ecid:id){
			electiveCourseService.deleteCourse(Integer.parseInt(ecid));
			msg="退选成功";
		}
		return ResultFactory.generateResult(ResultConstants.SUCCESS_CODE, 
				ResultConstants.SUCCESS_MSG,msg);
	}
	
	/**
	 *进入选题
	 * @author luojiayng
	 * */
	@RequestMapping(value = "/showCourseTopic",produces = "application/json;charset=utf-8")
	public ModelAndView showCourseTopic(HttpServletRequest request,HttpSession session, Integer cid) {
		UserTable get=(UserTable) session.getAttribute("user");
		ModelAndView mav=new ModelAndView();
	    if(get==null){
	    	mav.addObject("msg", " 操作失败");
	    }else{
	    	List<Topic> list=topicService.showCourseTopic(cid);
	    	mav.addObject("msg", " 操作失败");
	    }	
		return mav;
	}
	
	/**
	 * 成绩查询
	 * @author luojiayng
	 * */
	@RequestMapping(value = "/showCourseGrade",produces = "application/json;charset=utf-8")
	public ModelAndView showCourseGrade(HttpServletRequest request,HttpSession session) {
		UserTable get=(UserTable) session.getAttribute("user");
		ModelAndView mav=new ModelAndView();		
		 List<ShowCourseResult> list=electiveCourseService.showCourseGrade(get.getUtid());
	    mav.addObject("courselist", list);
	    mav.setViewName("index");
		return mav;
	}
	
	
	
	
	

}
