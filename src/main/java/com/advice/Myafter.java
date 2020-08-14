package com.advice;

import java.lang.reflect.Method;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

import com.pojo.Users;

public class Myafter implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		Logger logger = Logger.getLogger(Myafter.class);
		Users users = (Users) arg2[0];
		if (arg0!=null) {
			logger.info(users.getUsername()+"在"+new Date().toLocaleString()+"登录成功");
		}else {
			logger.info(users.getUsername()+"在"+new Date().toLocaleString()+"登录失败");
		}
	}

}
