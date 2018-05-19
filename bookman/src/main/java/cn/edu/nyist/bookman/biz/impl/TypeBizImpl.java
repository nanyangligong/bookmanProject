package cn.edu.nyist.bookman.biz.impl;

import java.util.List;

import cn.edu.nyist.bookman.biz.TypeBiz;
import cn.edu.nyist.bookman.dao.TypeDao;
import cn.edu.nyist.bookman.dao.impl.TypeDaoJdbcImpl;
import cn.edu.nyist.bookman.vo.TypeVo;

public class TypeBizImpl implements TypeBiz {

	@Override
	public List<TypeVo> findAllTypes() {
		TypeDao typeDao=new TypeDaoJdbcImpl();
		
		return typeDao.findAll();
	}

}
