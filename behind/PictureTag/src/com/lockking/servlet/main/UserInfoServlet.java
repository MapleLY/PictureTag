package com.lockking.servlet.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lockking.bean.User;
import com.lockking.dao.UserDao;

public class UserInfoServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String method = req.getParameter("method");
		if(method.equals("name")){
			getname(req, resp);
		}else if(method.equals("sex")){
			getsex(req, resp);
		}else if(method.equals("email")){
			getemail(req, resp);
		}
	}
	
	private void getname(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("名字");
		PrintWriter out = resp.getWriter();
		String account = req.getParameter("account");
		
		UserDao userDao = new UserDao();
		User user = userDao.getUserInfo(account);
		
		out.print(user.getUsername());
	}
	
	private void getsex(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("性别");
		PrintWriter out = resp.getWriter();
		String account = req.getParameter("account");
		
		UserDao userDao = new UserDao();
		User user = userDao.getUserInfo(account);
		
		out.print(user.getUsersex());
	}
	
	private void getemail(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("邮箱");
		PrintWriter out = resp.getWriter();
		String account = req.getParameter("account");
		
		UserDao userDao = new UserDao();
		User user = userDao.getUserInfo(account);
		
		out.print(user.getEmail());
	}
	
	
}
