package com.sixth.sport.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sixth.sport.action.base.BaseAction;
import com.sixth.sport.service.LoginService;
import com.sixth.sport.service.impl.LoginServiceImpl;

public class LoginAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private LoginService loginService;
	

	@Override
	protected void doPosts(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out) throws ServletException, IOException{
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	boolean flag=loginService.login(username,password);
		if(flag)
		{
			request.getSession().setAttribute("username", username);//把用户名保存到session当中
			request.getRequestDispatcher("/menu/home.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	
	}

	@Override
	protected void inits() throws ServletException{
		loginService=new LoginServiceImpl() ;
	}
	
	
	
}
