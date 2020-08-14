package com.advice;

import java.lang.reflect.Method;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

import com.pojo.Users;

public class Mybefore implements MethodBeforeAdvice{

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		Users users = (Users) arg1[0];
		Logger logger = Logger.getLogger(Mybefore.class);
		logger.info(users.getUsername()+"在"+new Date().toLocaleString()+"进行登录");
	}
}
