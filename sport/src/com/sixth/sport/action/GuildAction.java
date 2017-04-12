package com.sixth.sport.action;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sixth.sport.action.base.BaseAction;
import com.sixth.sport.domain.Guild;
import com.sixth.sport.domain.Systemddl;
import com.sixth.sport.service.GuildService;
import com.sixth.sport.service.impl.GuildServiceImpl;
import com.sixth.sport.utils.PageBean;

public class GuildAction extends BaseAction {

	private GuildService guildservice;
	
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPosts(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out)
			throws ServletException, IOException {
			String action_flag = request.getParameter("action_flag");
			if(action_flag.equals("show")){
				showGuild(request,response,path,out);
			}else if(action_flag.equals("del")){
				deleteGuild(request,response,path,out);
			}else if(action_flag.equals("showadd")){
				showAddGuild(request,response,path,out);
			}else if(action_flag.equals("add")){
				addGuild(request,response,path,out);
			}else if(action_flag.equals("dels")){
				delsGuild(request,response,path,out);
			}else if(action_flag.equals("edit")){
				editGuild(request,response,path,out);
			}else if(action_flag.equals("editadd")){
				editAddGuild(request,response,path,out);
			}
			
	}

	private void editGuild(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out) 
		throws ServletException, IOException {
		String id=request.getParameter("editid");
		Guild guild = guildservice.findById(id);
		List<Systemddl> list = guildservice.findByKeyword("是否发布");
		if(guild!=null)
		{
			request.setAttribute("sys", list);
			request.setAttribute("guild",guild );
			request.setAttribute("guildid",id);
			request.getRequestDispatcher("/system/guildEdit.jsp").forward(request, response);
		}
		
	}

	private void editAddGuild(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out) throws IOException {
		String guildname=request.getParameter("guildname");
		String guildtime=request.getParameter("guildtime");
		String guildis=request.getParameter("guildis");
		String guildcommon=request.getParameter("guildcommon");
		String guildremark=request.getParameter("guildremark");
		String sid =request.getParameter("id");
		int id=Integer.parseInt(sid);
		boolean result = guildservice.updateGuild(guildname,guildtime,guildcommon,guildis,guildremark,id);
		if (result) {
			response.sendRedirect(path + "/guildAction?action_flag=show");
		}
		
	}

	

	private void delsGuild(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out) throws IOException {
		String ids = request.getParameter("ids");
		String[] idss=ids.split(",");
		boolean flag = guildservice.delGuilds(idss);
		if (flag) {
			response.sendRedirect(path + "/guildAction?action_flag=show");
		}
		
	}

	private void addGuild(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out) throws IOException {
		String guildname =request.getParameter("guildname");
		String guildtime = request.getParameter("guildtime");
		String guildcommon = request.getParameter("guildcommon");
		String guildis=request.getParameter("guildis");
		String guildremark=request.getParameter("guildremark");
		boolean reslut =guildservice.addGuild(guildname,guildtime,guildcommon,guildis, guildremark);
		if(reslut){
			response.sendRedirect(path+"/GuildAction?action_flag=show");
		}
		
	}

	private void showAddGuild(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out) throws ServletException, IOException {
		List<Systemddl> list =guildservice.findByKeyword("是否发布");
		if(list!=null){
			request.setAttribute("guildis", list);
			request.getRequestDispatcher("/system/guildAdd.jsp").forward(request, response);
		}
		
	}

	private void deleteGuild(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out) throws IOException {
		String delId=request.getParameter("delId");
		if(delId!=null){
			boolean flag =guildservice.deleteGuildById(Integer.parseInt(delId));
			if(flag){
				response.sendRedirect(path+"/guildAction?action_flag=show");
			}
		}
		
	}

	private void showGuild(HttpServletRequest request,
			HttpServletResponse response, String path, PrintWriter out) throws ServletException, IOException {
		String guildname =request.getParameter("guildname");
		int recordCount = guildservice.getItemCount();
		int currentPage =1;
		String pageNum =request.getParameter("pageNum");
		if(pageNum!=null){
			currentPage=Integer.parseInt(pageNum);
		}
		PageBean pagebean = new PageBean(5,recordCount,currentPage);
		int start =pagebean.getFromIndex();
		int end =pagebean.getToIndex();
		List<Guild> guilds =guildservice.findGuild(guildname, start, end);
		request.setAttribute("guilds", guilds);
		request.setAttribute("pagebean", pagebean);
		request.getRequestDispatcher("/system/guildIndex.jsp").forward(request, response);
		
	}

	@Override
	protected void inits() throws ServletException {
		guildservice =new GuildServiceImpl();
		
	}

	
}
