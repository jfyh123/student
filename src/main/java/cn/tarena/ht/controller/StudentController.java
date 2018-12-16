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
import cn.tarena.ht.pojo.UserTable;
import cn.tarena.ht.result.SelectAllCourseResult;
import cn.tarena.ht.result.ShowCourseResult;
import cn.tarena.ht.service.CourseService;
import cn.tarena.ht.service.ElectiveCourseService;
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
	
	/**
	 * 学生选课
	 * @author luojiayng
	 * */
	@RequestMapping(value = "/electiveCourse",produces = "application/json;charset=utf-8")
	public ModelAndView electiveCourse(HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
	    List<SelectAllCourseResult> list =courseService.selectAllCourse();
		mav.addObject("coursedate", list);
		mav.setViewName("index");
		return mav;
	}
	
	/**
	 * 选择课程
	 * @author luojiayng
	 * */
	//TODO  还有一个数据的校验没有做完
	@RequestMapping(value = "/selectCourse",produces = "application/json;charset=utf-8")
	public ModelAndView selectCourse(HttpServletRequest request,Integer cid,Integer utid) {
		ModelAndView mav=new ModelAndView();
		String msg="";
		boolean flag =true;
		if(cid==null||utid==null){
			msg="操作数据有误";
			flag=false;
		}
	    int i=electiveCourseService.InsertElectiveCourse(cid,utid);
	    if(i!=1){
	    	msg="操作数据有误";
			flag=false;
	    }
	    mav.addObject("msg", msg);
	    if(flag){
	    	mav.setViewName("index");
	    }else{
	    	mav.setViewName("index");
	    }
		return mav;
	}
	
	/**
	 * 列出学生已选课程
	 * @author luojiayng
	 * */
	@RequestMapping(value = "/showCourse",produces = "application/json;charset=utf-8")
	public ModelAndView ShowCourse(HttpServletRequest request,Integer utid) {
		ModelAndView mav=new ModelAndView();
		String msg="";
		boolean flag =true;
		if(utid==null){
			msg="操作数据有误";
			flag=false;
		}
		 List<ShowCourseResult> list=electiveCourseService.showCourse(utid);
	    if(flag){
	    	mav.addObject("courselist", list);
	    	mav.setViewName("index");
	    }else{
	    	mav.addObject("msg", msg);
	    	mav.setViewName("index");
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
