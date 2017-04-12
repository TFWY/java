package com.sixth.sport.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sixth.sport.action.base.BaseAction;
import com.sixth.sport.domain.Spor_train;
import com.sixth.sport.domain.Systemddl;
import com.sixth.sport.service.TrainService;
import com.sixth.sport.service.impl.TrainServiceimp;
import com.sixth.sport.utils.PageBean;


public class TrainAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	TrainService trainService;
	@Override
	protected void doPosts(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out)
			throws ServletException, IOException {
		String action_flag = request.getParameter("action_flag");
		if (action_flag.equals("show")) {
			showTrain(request, response, path, out);
		} else if (action_flag.equals("del")) {
			deleteTrain(request, response, path, out);
		} else if (action_flag.equals("showadd")) {
			showAddTrain(request, response, path, out);
		} else if (action_flag.equals("add")) {
			addTrain(request, response, path, out);
		} else if (action_flag.equals("edit")) {
			editTrain(request, response, path, out);
		} else if(action_flag.equals("saveupdate")){
			saveTrain(request, response, path, out);
		}else if(action_flag.equals("dels"))
		{
			delsClass(request, response, path, out);
		}
		
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
			HttpServletResponse response, String path, PrintWriter out) throws IOException {
		String ids = request.getParameter("ids");
		String[] idss=ids.split(",");
		boolean flag = trainService.delTrains(idss);
		if (flag) {
			response.sendRedirect(path + "/trainAction?action_flag=show");
		}
		
	}

	/**
	 * 编辑保存
	 * @param request
	 * @param response
	 * @param path
	 * @param out
	 * @throws IOException 
	 */
	private void saveTrain(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out) throws IOException {
		String trainnum = request.getParameter("trainnum");
		String trainname = request.getParameter("trainname");
		String trainteacher = request.getParameter("trainteacher");
		String trainSchool = request.getParameter("trainId");
		String trainaddress = request.getParameter("trainaddress");
		String traintime = request.getParameter("traintime");
		String remark = request.getParameter("remark");
		String id=request.getParameter("trainid");
		boolean result = trainService.updateTrain(trainnum, trainname, trainteacher,
				trainSchool, trainaddress, traintime, remark,id);
		if (result) {
			response.sendRedirect(path + "/trainAction?action_flag=show");
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
	private void editTrain(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out) throws ServletException, IOException {
		String editId=request.getParameter("editId");
		Spor_train tra=trainService.findById(editId);
		List<Systemddl> list = trainService.findByKeyword("培训校区");
		if(tra!=null)
		{
			request.setAttribute("editsys", list);
			request.setAttribute("edittrain", tra);
			request.getRequestDispatcher("/system/trainEdit.jsp").forward(request, response);
		}
		
	}

	/**
	 * 添加信息
	 * 
	 * @param request
	 * @param response
	 * @param path
	 * @param out
	 * @throws IOException 
	 */
	private void addTrain(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out) throws IOException {
		String trainnum = request.getParameter("trainnum");
		String trainname = request.getParameter("trainname");
		String trainteacher = request.getParameter("trainteacher");
		String trainSchool = request.getParameter("trainId");
		String trainaddress = request.getParameter("trainaddress");
		String traintime = request.getParameter("traintime");
		String remark = request.getParameter("remark");
		boolean result = trainService.addTrain(trainnum, trainname, trainteacher,
				trainSchool, trainaddress, traintime, remark);
		if (result) {
			response.sendRedirect(path + "/trainAction?action_flag=show");
		}
		
	}

	/**
	 * 显示添加页面并传值
	 * 
	 * @param request
	 * @param response
	 * @param path
	 * @param out
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void showAddTrain(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out) throws ServletException, IOException {
		List<Systemddl> list = trainService.findByKeyword("培训校区");
		if (list != null) {
			request.setAttribute("schoollist", list);
			request.getRequestDispatcher("/system/trainAdd.jsp").forward(
					request, response);
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
	private void deleteTrain(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out) throws IOException {
		String delId = request.getParameter("delId");
		if (delId != null) {
			boolean flag = trainService.deleteTrainById(Integer.parseInt(delId));
			if (flag) {
				response.sendRedirect(path + "/trainAction?action_flag=show");
			}
		}
		
	}

	/**
	 * 显示培训信息列表
	 * 
	 * @param request
	 * @param response
	 * @param path
	 * @param out
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void showTrain(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out) throws ServletException, IOException {
		String trainnum=request.getParameter("trainnum");
		int currpage=1;
		String pagenum=request.getParameter("pageNum");
		int recordcount=trainService.getItemcount();
		if(pagenum!=null){
			currpage=Integer.parseInt(pagenum);
		}
		PageBean pageBean=new PageBean(5, recordcount, currpage);
		int star=pageBean.getFromIndex();
		int end=pageBean.getToIndex();
		List<Spor_train> trains= trainService.findtrain(trainnum,star,end);
		request.setAttribute("trains", trains);
		request.setAttribute("pageNum", pagenum);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("/system/trainIndex.jsp").forward(request, response);
		
	}

	@Override
	protected void inits() throws ServletException {
		trainService=new TrainServiceimp();
		
	}

}
