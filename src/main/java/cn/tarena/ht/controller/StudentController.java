package cn.tarena.ht.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.tarena.ht.pojo.Course;
import cn.tarena.ht.pojo.UserTable;
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
	    List<Course> list =courseService.selectAllCourse();
		mav.addObject("coursedate", list);
		mav.setViewName("index");
		return mav;
	}
	
	/**
	 * 选择课程
	 * @author luojiayng
	 * */
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
	
	
	
	

}
