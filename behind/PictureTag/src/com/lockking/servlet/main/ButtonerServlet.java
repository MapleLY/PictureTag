package com.lockking.servlet.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lockking.bean.Picture;
import com.lockking.bean.User;
import com.lockking.dao.PictureDao;
import com.lockking.dao.UserDao;

import net.sf.json.JSONSerializer;

public class ButtonerServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String method = req.getParameter("method");
		if(method.equals("addOne")){
			addlabel(req, resp);
		}else if(method.equals("getAll")){
			getlabel(req, resp);
		}else if(method.equals("searchLabel")){
			searchlabel(req, resp);
		}else if(method.equals("updateLabel")){
			updatelabel(req,resp);
		}
	}
	
	//获取标签信息（从用户账户中获取)
	private void searchlabel(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String account = req.getParameter("account");
		
		UserDao userDao = new UserDao();
		User user = userDao.getUserInfo(account);
		
		out.print(user.getLabellog());
	}
	
	//更新标签信息（从用户账户中更新）
	private void updatelabel(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String account = req.getParameter("account");
		String strpicid = req.getParameter("strpicid");
		String strlabel = req.getParameter("strlabel");
		String picstrlabel = req.getParameter("picstrlabel");
		
		UserDao userDao = new UserDao();
		userDao.updateUserLabel(account, strlabel);
		
		PictureDao pictureDao = new PictureDao();
		pictureDao.addLabel(strpicid, picstrlabel);
		
	}
	
	
	//获取标签（从图片信息中获取）
	private void getlabel(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String picid = req.getParameter("id");
		
		PictureDao pictureDao = new PictureDao();
		Picture picture = pictureDao.getPicInfo(picid);
		
		String strlabel = picture.getStrlabel();
		System.out.println(strlabel);
		out.print(strlabel);
	}
	
	
	//文本输入添加标签
	private void addlabel(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		String picid = req.getParameter("strpicid");//获取到当前图片的id
		String golabeltext = req.getParameter("labeltext");//获取到了新添加的标签
		String labeltext = "a*" + golabeltext + "+1";
		
		PictureDao pictureDao = new PictureDao();
		Picture picture = pictureDao.getPicInfo(picid);//获取当前图片信息
		
		String oldlabel = picture.getStrlabel();//获取当前图片的标签
		System.out.println("老的为="+oldlabel);
		String nowlabel = "";//最新的图片标签
		if(oldlabel!=null&&!oldlabel.equals("")){
			System.out.println("1");
			nowlabel = oldlabel + "," + labeltext;
		}else{
			System.out.println("2");
			nowlabel = labeltext;
		}
		
		String boolend = pictureDao.addLabel(picid ,nowlabel);
		if(boolend.equals("true")){
			out.print("true");
		}else{
			out.print("false");
		}
	}
}
