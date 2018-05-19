package cn.edu.nyist.bookman.web;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.nyist.bookman.biz.AdminBiz;
import cn.edu.nyist.bookman.biz.impl.AdminBizimpl;






/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取参数
		//调用业务逻辑
		//根据业务调用结果返回对应视图
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		String vcode=request.getParameter("vcode");
		//在查询数据库之前先搞验证码
		HttpSession session=request.getSession();
		String serverVcode=(String) session.getAttribute("validateCode");
		if(serverVcode.equalsIgnoreCase(vcode)) {
			request.setAttribute("msg", "验证码错误");
			request.setAttribute("name", name);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		AdminBiz adminBiz=new AdminBizimpl();
		boolean ret=adminBiz.findAdminByNameAndPwd(name,pwd);
		
		if(ret) {
			response.sendRedirect("main.jsp");
		}else {
			
			request.setAttribute("msg", "用户名或密码错误");
			request.setAttribute("name", name);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
