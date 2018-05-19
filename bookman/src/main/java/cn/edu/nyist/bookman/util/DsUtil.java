package cn.edu.nyist.bookman.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.mchange.v2.c3p0.ComboPooledDataSource;


public class DsUtil {

	private static ComboPooledDataSource ds=new ComboPooledDataSource();
	
	public static Connection getconn() throws SQLException {
		
		
		return ds.getConnection();
		
	}
	
	public static void free(ResultSet rs,PreparedStatement stmt,Connection conn) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
