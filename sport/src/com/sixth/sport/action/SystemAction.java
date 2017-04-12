package com.sixth.sport.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sixth.sport.action.base.BaseAction;
import com.sixth.sport.domain.Systemddl;
import com.sixth.sport.service.SystemService;
import com.sixth.sport.service.impl.SystemServiceImpl;

public class SystemAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SystemService systemService;

	@Override
	protected void doPosts(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out)
			throws ServletException, IOException {
		String action_flag = request.getParameter("action_flag");
		if (action_flag.equals("show")) {
			showSystemddl(request, response, path, out);
		} else if (action_flag.equals("edit")) {
			editSystemddl(request, response, path, out);
		} else if (action_flag.equals("save")) {
			saveSystemddl(request, response, path, out);
		}else if(action_flag.equals("del")){
			delSystemddl(request, response, path, out);
		}

	}

	/**
	 * 删除数据
	 * @param request
	 * @param response
	 * @param path
	 * @param out
	 * @throws IOException 
	 */
	private void delSystemddl(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out) throws IOException {
		String delid=request.getParameter("delid");
		if(delid!=null)
		{
			boolean flag=systemService.delSystemddl(Integer.parseInt(delid));
			if (flag) {
				response.sendRedirect(path+"/systemAction?action_flag=show");
			}
		}
	}

	/**
	 * 保存数据
	 * 
	 * @param request
	 * @param response
	 * @param path
	 * @param out
	 */
	private void saveSystemddl(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out) throws ServletException, IOException {
		String typeflag=request.getParameter("typeflag");
		String keywordnew=request.getParameter("keywordname");
		String[] itemname=request.getParameterValues("itemname");
		if(typeflag.equals("addsave"))
		{
			systemService.saveSystemddl(keywordnew,itemname);
			
		}else if(typeflag.equals("updatesave")){
			systemService.updateSystemddl(keywordnew,itemname);
			
		}
		response.sendRedirect(path+"/systemAction?action_flag=show");
	}

	/**
	 * 编辑
	 * 
	 * @param request
	 * @param response
	 * @param path
	 * @param out
	 */
	private void editSystemddl(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out) throws ServletException, IOException {
	String keyword=request.getParameter("keyword");
	//System.out.print(keyword);
	List<Systemddl> systems=systemService.findByKeyWord(keyword);
	if(systems!=null)
	{
		//System.out.print("!null");
		request.setAttribute("systems", systems);
		request.getRequestDispatcher("/system/dictionaryEdit.jsp")
				.forward(request, response);
	}

	}

	/**
	 * 传递数据到数据字典页面
	 * 
	 * @param request
	 * @param response
	 * @param path
	 * @param out
	 */
	private void showSystemddl(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out)
			throws ServletException, IOException {
		List<Systemddl> systemddls = systemService.findKeyWord();
		if (systemddls != null) {
			request.setAttribute("systemddls", systemddls);
			request.getRequestDispatcher("/system/dictionaryIndex.jsp")
					.forward(request, response);
		}

	}

	@Override
	protected void inits() throws ServletException {
		systemService = new SystemServiceImpl();

	}

}
