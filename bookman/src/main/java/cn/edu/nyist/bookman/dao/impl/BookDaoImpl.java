package cn.edu.nyist.bookman.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.nyist.bookman.dao.BookDao;
import cn.edu.nyist.bookman.util.DsUtil;
import cn.edu.nyist.bookman.vo.BookVo;

public class BookDaoImpl implements BookDao {

	@Override
	public int save(BookVo bookVo) {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
			conn=DsUtil.getconn();
			String sql="insert into t_book(tid,name,descri,photo,price,author,PubDate) values(?,?,?,?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1,bookVo.getTid());
			stmt.setString(2,bookVo.getName());
			stmt.setString(3,bookVo.getDescri());
			stmt.setString(4,bookVo.getPhoto());
			stmt.setDouble(5, bookVo.getPrice());
			stmt.setString(6, bookVo.getAuthor());
			stmt.setDate(7,new java.sql.Date(bookVo.getPubDate().getTime()));
			int ret=stmt.executeUpdate();
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DsUtil.free(rs, stmt, conn);

		}
		return 0;
	}

	
}
