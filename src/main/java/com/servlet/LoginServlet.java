package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.pojo.Users;
import com.service.UsersService;
import com.service.impl.UsersServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private UsersService usersService;

	@Override
	public void init() throws ServletException {
		ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		usersService = ac.getBean("userService", UsersServiceImpl.class);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Users u = new Users();
		u.setUsername(username);
		u.setPassword(password);
		Users login = usersService.login(u);
		if (login != null) {
			resp.sendRedirect("main.jsp");
		} else {
			resp.sendRedirect("login.jsp");
		}

	}
}
