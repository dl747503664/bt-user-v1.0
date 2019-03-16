package com.bt.sys.dao;


import java.util.List;

import com.bt.sys.entity.User;

public interface UserDao {
	public List<User> selectUser();
	public List<User> selectUserByName(String name);
	public void saveUser(User user);
	public void deleteUser(User user);
	public void updateUser(User user);
}
