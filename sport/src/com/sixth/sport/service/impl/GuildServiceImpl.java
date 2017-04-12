package com.sixth.sport.service.impl;

import java.util.ArrayList;
import java.util.List;


import com.sixth.sport.dao.GuildDao;
import com.sixth.sport.dao.impl.GuildDaoImpl;
import com.sixth.sport.domain.Guild;
import com.sixth.sport.domain.Systemddl;
import com.sixth.sport.service.GuildService;
import com.sixth.sport.service.SystemService;

public class GuildServiceImpl implements GuildService {

	private GuildDao guilddao;
	private SystemService systemService;
	
	public GuildServiceImpl(){
		guilddao =new GuildDaoImpl();
		systemService =new SystemServiceImpl();
	}
	
	@Override
	public boolean addGuild(String guildname, String guildtime,
			String guildcommon, String guildis, String guildremark) {
		List<Object> params =new ArrayList<Object>();
		params.add(guildname);
		params.add(guildtime);
		params.add(guildcommon);
		params.add(guildis);
		params.add(guildremark);
		return guilddao.addGuild(params);
	}

	@Override
	public boolean delGuilds(String[] idss) {
		
		return guilddao.delGuilds(idss);
	}

	@Override
	public boolean deleteGuildById(int id) {
		return guilddao.deleteGuildById(id);
	}

	@Override
	public Guild findById(String Id) {
		Guild spo=new Guild();
		int id=Integer.parseInt(Id);
		List<Object> params=new ArrayList<Object>();
		params.add(id);
		Guild users=guilddao.findById(params);
		spo.setId(users.getId());
	    spo.setGuildname(users.getGuildname());
	    spo.setGuildtime(users.getGuildtime());
		spo.setGuildis(users.getGuildis()!=null&&!users.getGuildis().equals("")?systemService.findByddlName(users.getGuildis(), "是否发布"):"");
		spo.setGuildcommon(users.getGuildcommon());
		spo.setGuildremark(users.getGuildremark());
	   return spo;
	}

	@Override
	public List<Systemddl> findByKeyword(String keyword) {
		return systemService.findByKeyWord(keyword);
	}

	@Override
	public List<Guild> findGuild(String Guildname, int start, int end) {
		List<Guild> guilds =new ArrayList<Guild>();
		Guild guild;
		List<Guild> list = guilddao.findGuild(Guildname, start, end);
		for(Guild gu : list){
			guild=new Guild();
			guild.setId(gu.getId());
			guild.setGuildname(gu.getGuildname());
			guild.setGuildtime(gu.getGuildtime());
			guild.setGuildcommon(gu.getGuildcommon());
			guild.setGuildis(gu.getGuildis()!=null&&!gu.getGuildis().equals("")?systemService.findByddlName(gu.getGuildis(),"是否发布"):"");
			guild.setGuildremark(gu.getGuildremark());
			guilds.add(guild);
		}
		return guilds;
	}

	@Override
	public int getItemCount() {
		return guilddao.getItemCount();
	}

	@Override
	public boolean updateGuild(String guildname, String guildtime,
			String guildcommon, String guildis, String guildremark, int id) {
		List<Object> params=new ArrayList<Object>();
		params.add(guildname);
		params.add(guildtime);
		params.add(guildcommon);
		params.add(guildis);
		params.add(guildremark);
		params.add(id);
		return guilddao.updateGuild(params);
	}

}
