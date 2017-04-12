package com.sixth.sport.action.base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String path = request.getContextPath();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		doPosts(request, response, path, out);
		out.flush();
		out.close();
	}

	/**
	 * 简单封装dopost方法
	 * 
	 * @param request
	 * @param response
	 * @param path
	 * @param out
	 */
	protected abstract void doPosts(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out) throws ServletException, IOException ;

	@Override
	public void init() throws ServletException {
		inits();
	}

	/**
	 * 初始化
	 */
	protected abstract void inits() throws ServletException;

}
