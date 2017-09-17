package com.lockking.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.lockking.bean.User;
import com.lockking.util.DBUtil;

public class UserDao {
	
	//获取用户信息
	public User getUserInfo(String straccount){
		Connection conn = DBUtil.getConn();
		Statement state = null;
		ResultSet rs = null;
		
		User user = null;
		
		try {
			state = conn.createStatement();//创建语句对象
			rs = state.executeQuery("select * from userinfo where account = '" + straccount + "'");
			if(rs.next()){
				user = new User();
				user.setUserid(String.valueOf(rs.getInt("userid")));
				user.setAccount(rs.getString("account"));
				user.setPassword(rs.getString("password"));
				user.setLabellog(rs.getString("labellog"));
				user.setUsername(rs.getString("username"));
				user.setUsersex(rs.getString("usersex"));
				user.setEmail(rs.getString("email"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(rs, state, conn);
		}
		return user;
	}
	
	//注册
		public String save(User user){
			Connection conn = DBUtil.getConn();
			Statement state = null;
			String sql = "insert into userinfo (account,password,email) values('"+user.getAccount()+"','"+user.getPassword()+"','"+user.getEmail()+"')";
			try {
				state = conn.createStatement();
				state.executeUpdate(sql);
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				DBUtil.close(null, state, conn);
			}
			return "success";
		}
	
	//修改用户标签信息
	public void updateUserLabel(String strid, String strlabel){
		Connection conn = DBUtil.getConn();
		Statement state = null;
		User user = null;
		try {
			state = conn.createStatement();//创建语句对象
			state.executeUpdate("update userinfo set labellog='"+ strlabel +"' where userid='"+ strid +"'");

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(state, conn);
		}
	}
}
