package cn.edu.nyist.bookman.biz.impl;

import cn.edu.nyist.bookman.biz.AdminBiz;
import cn.edu.nyist.bookman.dao.AdminDao;
import cn.edu.nyist.bookman.dao.impl.AdminDaoJdbcimpl;

public class AdminBizimpl implements AdminBiz {

	@Override
	public boolean findAdminByNameAndPwd(String name, String pwd) {
		// TODO Auto-generated method stub
		AdminDao adminDao=new AdminDaoJdbcimpl();
		return adminDao.get(name,pwd);
	}

	

}
