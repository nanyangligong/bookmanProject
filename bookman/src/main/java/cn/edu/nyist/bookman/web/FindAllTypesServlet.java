package cn.edu.nyist.bookman.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.nyist.bookman.biz.TypeBiz;
import cn.edu.nyist.bookman.biz.impl.TypeBizImpl;
import cn.edu.nyist.bookman.vo.TypeVo;



@WebServlet("/FindAllTypes")
public class FindAllTypesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FindAllTypesServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		
		
		
	}

}
