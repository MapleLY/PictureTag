package com.lockking.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	//数据库连接信息
	public static String db_url = "jdbc:mysql://localhost:3306/picturetag?useunicode=true&characterEncoding=utf8";//存取数据时，数据和字节码之间转换都以UTF-8的格式进行
	public static String db_user = "root";
	public static String db_password = "0214";
	

	/**
	 * 连接数据库
	 * @return
	 */
	public static Connection getConn(){
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");//加载驱动类，进行初始化
			conn = DriverManager.getConnection(db_url, db_user, db_password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	

	/**
	 * 关闭数据库
	 * @param state
	 * @param conn
	 */
	public static void close(Statement state, Connection conn){
		if(state!=null){
			try {
				state.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 关闭数据库
	 * @param rs
	 * @param state
	 * @param conn
	 */
	public static void close(ResultSet rs, Statement state, Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(state!=null){
			try {
				state.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
