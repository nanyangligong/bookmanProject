package cn.edu.nyist.bookman.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import cn.edu.nyist.bookman.dao.TypeDao;
import cn.edu.nyist.bookman.util.DsUtil;
import cn.edu.nyist.bookman.vo.TypeVo;

public class TypeDaoJdbcImpl implements TypeDao {

	@Override
	public List<TypeVo> findAll() {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
			conn=DsUtil.getconn();
			String sql="select *from t_type";
			stmt=conn.prepareStatement(sql);
		    rs=stmt.executeQuery();
		    List<TypeVo> ls=new ArrayList<>();
		    while(rs.next()) {
		    	TypeVo typeVo=new TypeVo();
		    	typeVo.setId(rs.getInt("id"));
		    	typeVo.setName(rs.getString("name"));
		    	ls.add(typeVo);
		    }
		    return ls;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DsUtil.free(rs, stmt, conn);
		}
		return null;
	}

}
