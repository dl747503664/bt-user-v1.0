package com.bt.sys.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bt.sys.vo.JsonResult;
/**
 * 全局异常处理类
 * @author Administrator
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	  
	  @ExceptionHandler(Exception.class)
	  @ResponseBody
	  public JsonResult doHandleException(
			  Exception e){
		  System.out.println("GlobalExceptionHandler.doHandleException");
		  e.printStackTrace();
		  //System.out.println(e instanceof ServiceException);
		  return new JsonResult(e);//封装异常
	  }
	  @ExceptionHandler(Throwable.class)
	  @ResponseBody
	  public JsonResult doHandleThrowable(
			  Throwable e){
		  e.printStackTrace();
		  JsonResult r=new JsonResult();
		  r.setState(0);
		  r.setMessage("系统运维中");
		  //给运维人员发短信
		  return r;//封装异常
	  }
	  
}
