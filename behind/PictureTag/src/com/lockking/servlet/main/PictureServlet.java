package com.lockking.servlet.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lockking.bean.Picture;
import com.lockking.dao.PictureDao;

public class PictureServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("进入后台程序");
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String method = req.getParameter("method");
		if(method.equals("getPicNumber")){
			getPicNumber(req, resp);
		}else if(method.equals("getPicId")){
			getPicInfo(req, resp);
		}
		
	}
	
	//获取图片数量
	private void getPicNumber(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		PictureDao pictureDao = new PictureDao();
		int pictureNumber = pictureDao.getPicNumber();
		
		out.print(pictureNumber);
	}
	
	//获取图片信息
	private void getPicInfo(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String picid = req.getParameter("id");
		
		PictureDao pictureDao = new PictureDao();
		Picture picture = pictureDao.getPicInfo(picid);
		
		out.print(picture.getPicurl());
	}
}
