package cn.tarena.ht.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	 * 测试的地方
	 * 查询所有用户
	 * @author luojiayng
	 * */
	@RequestMapping(value = "/allUser",produces = "application/json;charset=utf-8")
	public @ResponseBody Result  AllIndustry(HttpServletRequest request) {
		List<UserTable> list =userService.selectAllUser();
		UserTable user=new UserTable();
		int aa=userService.insertOneUser(user);
		System.out.println(user.getUtid());
		Result rs=ResultFactory.generateResult(ResultConstants.SUCCESS_CODE, ResultConstants.SUCCESS_MSG,list);
		return rs;
	}
	
	/**
	 * 用户登录
	 * @author luojiayng
	 * */
	@RequestMapping(value = "/login",produces = "application/json;charset=utf-8")
	public @ResponseBody Result  userLogin(HttpServletRequest request,@RequestBody UserTable u) {
		if(MyTools.isNullOrEmpty(u.getUname())||MyTools.isNullOrEmpty(u.getUname())){
			return ResultFactory.generateResult(ResultConstants.PARAMETER_CODE, 
					ResultConstants.PARAMETER_MSG);
		}
		UserTable user=userService.UserLogin(u.getUname());
		if(user==null){
			return ResultFactory.generateResult(ResultConstants.ACCOUNT_NULL_ERROR_CODE, 
					ResultConstants.ACCOUNT_NULL_ERROR_MSG);
		}else{
			if(user.equals(u.getPwd())){
				return ResultFactory.generateResult(ResultConstants.PASSWORD_ERROR_CODE, 
						ResultConstants.PASSWORD_ERROR_MSG);
			}
			if(user.getStatus()==1){
				return ResultFactory.generateResult(ResultConstants.FREEZE_ERROR_CODE, 
						ResultConstants.FREEZE_ERROR_MSG);
			}
			return ResultFactory.generateResult(ResultConstants.SUCCESS_CODE, ResultConstants.SUCCESS_MSG,user);
		}
	}
	
}
