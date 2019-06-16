package cn.tarena.ht.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.tarena.ht.pojo.UserTable;
import cn.tarena.ht.service.UserService;
import cn.tarena.ht.utils.MyTools;
import cn.tarena.ht.utils.Result;
import cn.tarena.ht.utils.ResultConstants;
import cn.tarena.ht.utils.ResultFactory;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;
	/**
	 *推出
	 *@author luojiayng
	 * */
	@RequestMapping(value = "/loginOut",produces = "application/json;charset=utf-8")
	public ModelAndView loginOut(HttpServletRequest request,UserTable u,HttpSession session) {
		ModelAndView mav=new ModelAndView();
		session.removeAttribute("user");
		mav.setViewName("login");
		return mav;
	}
	

	/**
	 * 用户登录
	 * @author luojiayng
	 * */
	@RequestMapping(value = "/login",produces = "application/json;charset=utf-8")
	public ModelAndView UserController(HttpServletRequest request,UserTable u,HttpSession session) {
		ModelAndView mav=new ModelAndView();
		String msg="";
		int status=200;
		boolean flag =true;
		UserTable user = null;
		if(MyTools.isNullOrEmpty(u.getUname())||MyTools.isNullOrEmpty(u.getUname())){
			flag = false;
			msg = "操作数据有误";
		}else{
			user=userService.UserLogin(u.getUname());
			if(user==null){
				flag = false;
				status=500;
				msg = "用户不存在";
			}else{
				if(!user.getPwd().equals(u.getPwd())){
					flag = false;
					status=500;
					msg = "密码错误";
				}
				if(user.getStatus()==1){
					flag = false;
					status=500;
					msg = "用户已冻结！";
				}
			}
			
		}
		if(flag){
			mav.addObject("userdate", user);
			mav.addObject("status", status);
			mav.setViewName("index");
		}else{
			mav.addObject("msg", msg);
			mav.addObject("status", status);
			mav.setViewName("login");
		}
		session.setAttribute("user", user);
		return mav;
	}
	
	/**
	 * 个人信息
	 * @author luojiayng
	 * */
	@RequestMapping(value = "/information",produces = "application/json;charset=utf-8")
	public ModelAndView  information(HttpServletRequest request,UserTable u,HttpSession session) {
		ModelAndView mav=new ModelAndView();
		UserTable get=(UserTable) session.getAttribute("user");
		UserTable user=userService.Information(get.getUtid());
			mav.addObject("userdate", user);
			mav.setViewName("info");
		return mav;
	}
	
	/**
	 * 保存个人信息
	 * @author luojiayng
	 * */
	@RequestMapping(value = "/UpdateInformation",produces = "application/json;charset=utf-8")
	public @ResponseBody Result  UpdateInformation(HttpServletRequest request,UserTable u,HttpSession session) {
		String msg="";
		UserTable get=(UserTable) session.getAttribute("user");
		u.setUtid(get.getUtid());
		int i=userService.UpdateInformation(u);
		if(i!=1){
			msg="保存失败";
			return ResultFactory.generateResult(ResultConstants.ERROR_CODE, 
					ResultConstants.ERROR_MSG,msg);
		}else{
			msg= "保存成功";
			return ResultFactory.generateResult(ResultConstants.SUCCESS_CODE, 
					ResultConstants.SUCCESS_MSG,msg);
		}	

	}
	/**
	 * 测试连接mysql/oracle
	 * @author luojiayng
	 * */
	@RequestMapping(value = "/test",produces = "application/json;charset=utf-8")
	public @ResponseBody Result  test() {
		List<UserTable> list=userService.selectAllUser();
		for(UserTable e:list){
			System.out.println(e.getUname());
		}
			return ResultFactory.generateResult(ResultConstants.ERROR_CODE, 
					ResultConstants.ERROR_MSG,list);
	}
	
	
}
