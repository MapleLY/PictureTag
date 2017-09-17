package com.lockking.servlet.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.lockking.bean.User;
import com.lockking.dao.UserDao;

public class LoginServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String method = req.getParameter("method");
		String a = req.getParameter("straccount");
		String b = req.getParameter("strpassword");
		if("login".equals(method)){
			login(req, resp);
		}
	}
	
	//登录
	private void login(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		
		PrintWriter out = resp.getWriter();
		
		String account = req.getParameter("straccount");
		String password = req.getParameter("strpassword");
		
		UserDao userDao = new UserDao();
		User user = userDao.getUserInfo(account);
		
		if(user!=null){
			if(user.getPassword().equals(password)){
				out.print(true);
			}else{
				out.print(false);
			}
		}else{
			out.print(false);
		}
	}
}