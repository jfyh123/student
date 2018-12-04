package cn.tarena.ht.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarena.ht.pojo.User;
import cn.tarena.ht.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	/*
	 * 查询所有用户
	 * */
	@RequestMapping("user/list")
	public String selectList(Model model) {
		
		List<User> list =userService.selectList();
		model.addAttribute("dataList",list);
		return "/sysadmin/user/jUserList";
	}
	
}
