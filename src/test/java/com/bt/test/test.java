package com.bt.test;

import java.awt.print.Book;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bt.sys.entity.User;
import com.bt.sys.service.UserService;
import com.bt.sys.vo.JsonResult;

public class test {
	 private ApplicationContext context=null;
	    private UserService userService=null;
	    
	    {
	         context= new ClassPathXmlApplicationContext("applicationContext.xml");  
	         userService=context.getBean(UserService.class);
	    }
	    @Test
	    public void test()
	    {
	        DataSource dataSource=(DataSource) context.getBean(DataSource.class);
	        System.out.println(dataSource);
	    }
	    @Test
	    public void test1()
	    {
	    	List<User> user = userService.selectUserByName("lisi");
	        for(User user2 :user){
	        	System.out.println(user2);
	        }
	    }
	    @Test
	    public void test2()
	    {
	    	 List<User> user = userService.selectUser();
	        for(User user2 :user){
	        	System.out.println(user2);
	        }
	    }
	    
	    @Test
	    public void test3()
	    {
	        userService.saveUser(new User(null, "lisi", "18"));
	    }
	    @Test
	    public void test4()
	    {
	        userService.deleteUser(new User(3, null,null));
	    }
	    @Test
	    public void test5()
	    {
	        userService.updateUser(new User(4, "ll", "20"));
	    }
}
