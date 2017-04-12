package com.sixth.sport.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sixth.sport.action.base.BaseAction;
import com.sixth.sport.domain.SpoUser;
import com.sixth.sport.domain.Systemddl;
import com.sixth.sport.service.UserService;
import com.sixth.sport.service.impl.UserServiceImpl;
import com.sixth.sport.utils.PageBean;

public class UserAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserService userService;

	@Override
	protected void doPosts(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out)
			throws ServletException, IOException {
		String action_flag = request.getParameter("action_flag");
		if (action_flag.equals("show")) {
			showUser(request, response, path, out);
		} else if (action_flag.equals("del")) {
			deleteUser(request, response, path, out);
		} else if (action_flag.equals("showadd")) {
			showAddUser(request, response, path, out);
		} else if (action_flag.equals("add")) {
			addUser(request, response, path, out);
		} else if (action_flag.equals("edit")) {
			editUser(request, response, path, out);
		} else if(action_flag.equals("saveupdate"))
		{
			saveUser(request, response, path, out);
		}else if(action_flag.equals("dels"))
		{
			delsUser(request, response, path, out);
		}
	}
/**
 * �༭����
 * @param request
 * @param response
 * @param path
 * @param out
 */
	private void saveUser(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out) throws ServletException, IOException{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sexId = request.getParameter("sexId");
		String brithday = request.getParameter("brithday");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String remark = request.getParameter("remark");
		String id=request.getParameter("upId");
		boolean result = userService.updateUser(username, password, sexId,
				brithday, phone, email, remark,id);
		if (result) {
			response.sendRedirect(path + "/userAction?action_flag=show");
		}
		
	}

	/**
	 * �༭��ͨ��Id�ҵ���Ӧ��ֵ��
	 * 
	 * @param request
	 * @param response
	 * @param path
	 * @param out
	 */
	private void editUser(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out) throws ServletException, IOException{
		String editId=request.getParameter("editId");
		SpoUser user=userService.findById(editId);
		List<Systemddl> list = userService.findByKeyword("�Ա�");
		if(user!=null)
		{
			request.setAttribute("editsys", list);
			request.setAttribute("edituser", user);
			request.getRequestDispatcher("/system/userEdit.jsp").forward(request, response);
		}

	}

	/**
	 * ��ʾ���ҳ�沢���Ա��ֵ
	 * 
	 * @param request
	 * @param response
	 * @param path
	 * @param out
	 */
	private void showAddUser(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out)
			throws ServletException, IOException {
		List<Systemddl> list = userService.findByKeyword("�Ա�");
		if (list != null) {
			request.setAttribute("sexlist", list);
			request.getRequestDispatcher("/system/userAdd.jsp").forward(
					request, response);
		}
	}

	/**
	 * ����û�
	 * 
	 * @param request
	 * @param response
	 * @param path
	 * @param out
	 */
	private void addUser(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sexId = request.getParameter("sexId");
		String birthday = request.getParameter("birthday");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String remark = request.getParameter("remark");
		boolean result = userService.addUser(username, password, sexId,
				birthday, phone, email, remark);
		if (result) {
			response.sendRedirect(path + "/userAction?action_flag=show");
		}

	}

	/**
	 * ͨ��Idɾ��
	 * 
	 * @param request
	 * @param response
	 * @param path
	 * @param out
	 */
	private void deleteUser(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out)
			throws ServletException, IOException {
		String delId = request.getParameter("delId");
		if (delId != null) {
			boolean flag = userService.deleteUserById(Integer.parseInt(delId));
			if (flag) {
				response.sendRedirect(path + "/userAction?action_flag=show");
			}
		}
	}

	/**
	 * ��ʾ�û��б�
	 * 
	 * @param request
	 * @param response
	 * @param path
	 * @param out
	 */
	private void showUser(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out)
			throws ServletException, IOException {
		String username = request.getParameter("userName");

		int recordCount = userService.getItemCount();
		int currentPage = 1;
		String pageNum = request.getParameter("pageNum");
		if (pageNum != null) {
			currentPage = Integer.parseInt(pageNum);
		}
		PageBean pageBean = new PageBean(5, recordCount, currentPage);
		int start = pageBean.getFromIndex();
		int end = pageBean.getToIndex();
		List<SpoUser> users = userService.findUser(username, start, end);
		request.setAttribute("users", users);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("/system/userIndex.jsp").forward(request,
				response);

	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @param path
	 * @param out
	 * @throws ServletException
	 * @throws IOException
	 */
	private void delsUser(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out) throws ServletException, IOException{
		String ids = request.getParameter("ids");
		String[] idss=ids.split(",");
		boolean flag = userService.delUsers(idss);
		if (flag) {
			response.sendRedirect(path + "/userAction?action_flag=show");
		}
	}
		
	@Override
	protected void inits() throws ServletException {
		// TODO Auto-generated method stub
		userService = new UserServiceImpl();
	}

}
