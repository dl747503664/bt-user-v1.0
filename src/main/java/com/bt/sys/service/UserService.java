package com.bt.sys.service;

import java.util.List;

import com.bt.sys.entity.User;
import com.bt.sys.vo.JsonResult;

public interface UserService {
	public List<User> selectUser();
	public List<User> selectUserByName(String name);
	public JsonResult saveUser(User user);
	public JsonResult deleteUser(User user);
	public JsonResult updateUser(User user);
}
