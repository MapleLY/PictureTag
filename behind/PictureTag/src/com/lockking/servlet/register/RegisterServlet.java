package com.lockking.servlet.register;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lockking.bean.User;
import com.lockking.dao.UserDao;

public class RegisterServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		register(req, resp);
	}

	// 注册
	private void register(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String account = req.getParameter("straccount");
		String password = req.getParameter("strpassword");
		String email = req.getParameter("stremail");
		UserDao userDao = new UserDao();
		User user = new User();
		user.setAccount(account);
		user.setPassword(password);
		user.setEmail(email);
		String save = userDao.save(user);
		if (save.equals("success")) {
			out.print(true);
		} else {
			System.out.println("false");
			out.print(false);
		}
	}
}
