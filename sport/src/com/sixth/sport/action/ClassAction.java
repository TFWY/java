package com.sixth.sport.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sixth.sport.action.base.BaseAction;
import com.sixth.sport.domain.ClassInf;
import com.sixth.sport.service.ClassService;
import com.sixth.sport.service.impl.ClassServiceImpl;
import com.sixth.sport.utils.PageBean;

public class ClassAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ClassService classService;

	@Override
	protected void doPosts(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out)
			throws ServletException, IOException {
		String action_flag = request.getParameter("action_flag");
		if (action_flag.equals("show")) {
			showClass(request, response, path, out);
		} else if (action_flag.equals("del")) {
			deleteClass(request, response, path, out);
		}  else if (action_flag.equals("add")) {
			addClass(request, response, path, out);
		} else if (action_flag.equals("edit")) {
			editClass(request, response, path, out);
		}else if (action_flag.equals("showadd")) {
			showAddUser(request, response, path, out); 
		}else if(action_flag.equals("saveupdate"))
		{
			saveClass(request, response, path, out);
		}else if(action_flag.equals("dels"))
		{
			delsClass(request, response, path, out);
		}
		
	}
	

	private void showAddUser(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out) throws ServletException, IOException {
			request.getRequestDispatcher("/system/classAdd.jsp").forward(
					request, response);
		
		
	}


	private void saveClass(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out) throws IOException {
		String classname = request.getParameter("classname");
		String classId = request.getParameter("classid");
		String classtime = request.getParameter("classtime");
		String classcommon = request.getParameter("classcommon");
		String classremark = request.getParameter("classremark");
		String id=request.getParameter("upId");
		boolean result = classService.updateClass(classname, classId, classtime,
				classcommon, classremark,id);
		if (result) {
			//System.out.print("scc");
			response.sendRedirect(path + "/classAction?action_flag=show");
		}
	}

/**
 * 编辑（通过Id找到对应的值）
 * 
 * @param request
 * @param response
 * @param path
 * @param out
 * @throws IOException 
 * @throws ServletException 
 */

	private void editClass(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out) throws ServletException, IOException {
		String Id=request.getParameter("editId");
		ClassInf inf=classService.findById(Id);
		//System.out.print(inf.getClassName());
		if(inf!=null)
		{
			request.setAttribute("editclass", inf);
			request.getRequestDispatcher("/system/classEdit.jsp").forward(request, response);
		}
		
	}

	/**
	 * 添加用户
	 * 
	 * @param request
	 * @param response
	 * @param path
	 * @param out
	 * @throws IOException 
	 */
	private void addClass(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out) throws IOException {
		String classId = request.getParameter("classid");
		String className = request.getParameter("classname");
		String classtime = request.getParameter("classtime");
		String classcommon = request.getParameter("classcommon");
		String classremark = request.getParameter("classremark");
		boolean result = classService.addClass(classId,className, classtime,classcommon,classremark);
		if (result) {
			response.sendRedirect(path + "/classAction?action_flag=show");
		}
		
	}

	/**
	 * 通过Id删除
	 * 
	 * @param request
	 * @param response
	 * @param path
	 * @param out
	 * @throws IOException 
	 */
	private void deleteClass(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out) throws IOException {
		String delId = request.getParameter("delId");
		//System.out.print(delId);
		if (delId != null) {
			boolean flag = classService.deleteClassById(Integer.parseInt(delId));
			if (flag) {
				response.sendRedirect(path + "/classAction?action_flag=show");
			}
		}
	}


	/**
	 * 显示课程列表
	 * 
	 * @param request
	 * @param response
	 * @param path
	 * @param out
	 * @throws IOException 
	 * @throws ServletException 
	 */

	private void showClass(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out) 
			throws ServletException, IOException {
		String classId = request.getParameter("classId");
		
		int recordCount = classService.getItemCount();
		int currentPage = 1;
		String pageNum = request.getParameter("pageNum");
		if (pageNum != null) {
			currentPage = Integer.parseInt(pageNum);
		}
		PageBean pageBean = new PageBean(5, recordCount, currentPage);
		int start = pageBean.getFromIndex();
		int end = pageBean.getToIndex();
		List<ClassInf> inf = classService.findClass(classId, start, end);
		request.setAttribute("classInf", inf);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("/system/classIndex.jsp").forward(request,
				response);
	}

	
/**
 * 批量删除
 * 
 * @param request
 * @param response
 * @param path
 * @param out
 * @throws ServletException
 * @throws IOException
 */
	
	private void delsClass(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out) throws ServletException, IOException{
		String ids = request.getParameter("ids");
		String[] idss=ids.split(",");
		boolean flag = classService.delUsers(idss);
		if (flag) {
			response.sendRedirect(path + "/classAction?action_flag=show");
		}
	}
	@Override
	protected void inits() throws ServletException {
		// TODO Auto-generated method stub
		classService = new ClassServiceImpl();
	}

}
