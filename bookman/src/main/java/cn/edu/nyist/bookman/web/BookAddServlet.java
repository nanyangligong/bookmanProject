package cn.edu.nyist.bookman.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import cn.edu.nyist.bookman.biz.BookBiz;
import cn.edu.nyist.bookman.biz.impl.BookBizImpl;
import cn.edu.nyist.bookman.util.MyBeanUtils;
import cn.edu.nyist.bookman.vo.BookVo;

//�ļ��ϴ�

@WebServlet("/BookAdd")
@MultipartConfig
public class BookAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BookAddServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����ļ��ϴ�
		request.setCharacterEncoding("utf-8");
		//���ļ���
		Part part=request.getPart("photo");
		String fileName=part.getHeader("Content-Dosposition").split(";")[2].split("=")[1].replace("\"", "");
		//���IE�´�������
		fileName=fileName.lastIndexOf("\\")==-1?fileName:fileName.substring(fileName.lastIndexOf("\\")+1);
		
		//����hibernate.cfg.xml�����ļ���
		String ext=fileName.substring(fileName.lastIndexOf('.')+1);
		String newFileName=UUID.randomUUID().toString()+"."+ext;
		part.write(request.getServletContext().getRealPath("upload/")+newFileName);
		
        BookVo bookVo=new BookVo();
        MyBeanUtils.populate(bookVo, request.getParameterMap(),"yyyy-MM-dd");
        try {
			BeanUtils.populate(bookVo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bookVo.setPhoto(newFileName);
		
		//����ҵ��㱣��
		BookBiz bookBiz=new BookBizImpl();
		
		int ret=bookBiz.savebook(bookVo);
		
		//���û�����
		response.setContentType("text/html;charset=utf-8");
		if(ret>0) {
			response.getWriter().write("��ӳɹ�");
		}else {
			request.setAttribute("msg", "���ʧ��");
			request.getRequestDispatcher("bookAdd.jsp").forward(request, response);
		}
	}
   
	
}
