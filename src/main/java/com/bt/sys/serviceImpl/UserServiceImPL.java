package com.bt.sys.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bt.sys.dao.UserDao;
import com.bt.sys.entity.User;
import com.bt.sys.service.UserService;
import com.bt.sys.vo.JsonResult;
@Service
public class UserServiceImPL implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> selectUser() {
		List<User> userList;
		try {
			userList = userDao.selectUser();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("系统正在维护");
		}
		return userList;
	}

	@Override
	public List<User> selectUserByName(String name) {
		List<User> userList;
		try {
			userList = userDao.selectUserByName(name);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("系统正在维护");
		}
		return userList;
	}

	@Override
	public JsonResult saveUser(User user) {
		try {
			userDao.saveUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("新增失败");
		}
		return new JsonResult("OK");
	}

	@Override
	public JsonResult deleteUser(User user) {
		try {
			userDao.deleteUser( user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("删除失败");
		}
		return new JsonResult("OK");
	}

	@Override
	public JsonResult updateUser(User user) {
		try {
			userDao.updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("修改失败");
		}
		return new JsonResult("OK");
	}

	
}
