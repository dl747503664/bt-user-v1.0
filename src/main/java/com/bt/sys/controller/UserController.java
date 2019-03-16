package com.bt.sys.controller;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bt.sys.entity.User;
import com.bt.sys.service.UserService;
import com.bt.sys.vo.JsonResult;

@Controller
@RequestMapping("/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("user")
	public String selectUser(Model model){
		List<User> userList = userService.selectUser();
		model.addAttribute("userList",userList);
		return "user";
	}
	@RequestMapping("selectUserByName")
	@ResponseBody
	public JsonResult selectUserByName(String name,Model model){
		List<User> userList =userService.selectUserByName(name);
		System.out.println(userList);
		if(userList.isEmpty()){
			JsonResult jsonResult = new JsonResult("用户名输入错误或用户不存在");
			jsonResult.setState(0);
			return jsonResult;
		}
		return new JsonResult(userList);
	}
	@RequestMapping("save")
	@ResponseBody
	public JsonResult saveUser(User user){
		return userService.saveUser(user);
	}
	@RequestMapping("delete")
	@ResponseBody
	public JsonResult deleteUser(User user){
		return userService.deleteUser(user);
	}
	@RequestMapping("update")
	@ResponseBody
	public JsonResult updateUser(User user){
		return userService.updateUser(user);
	}
}
