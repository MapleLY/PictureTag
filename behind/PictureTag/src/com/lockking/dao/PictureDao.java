package com.lockking.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.lockking.bean.Picture;
import com.lockking.util.DBUtil;

public class PictureDao {
	//获取图片数量
	public int getPicNumber(){
		Connection conn = DBUtil.getConn();
		Statement state = null;
		ResultSet rs = null;
		
		int picnumber = 1;
		
		try {
			state = conn.createStatement();//创建语句对象
			rs = state.executeQuery("select count(*) from picinfo");
			rs.next();
			picnumber = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(rs, state, conn);
		}
		return picnumber;
	}
	
	//获取图片信息
	public Picture getPicInfo(String strid){
		Connection conn = DBUtil.getConn();
		Statement state = null;
		ResultSet rs = null;
		
		Picture picture = null;
		
		try {
			state = conn.createStatement();//创建语句对象
			rs = state.executeQuery("select * from picinfo where id ='" + strid + "'");
			if(rs.next()){
				picture = new Picture();
				picture.setId(rs.getString("id"));
				picture.setPicname(rs.getString("picname"));
				picture.setPicurl(rs.getString("picurl"));
				picture.setStrlabel(rs.getString("strlabel"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(rs, state, conn);
		}
		return picture;
	}
	
	//更新标签（文本输入，次数更改）
	public String addLabel(String picid, String nowlabel){
		Connection conn = DBUtil.getConn();
		Statement state = null;
		
		try {
			state = conn.createStatement();//创建语句对象
			state.executeUpdate("update picinfo set strlabel='"+ nowlabel +"' where id='"+ picid +"'");
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(state, conn);
		}
		return "false";
	}
}
