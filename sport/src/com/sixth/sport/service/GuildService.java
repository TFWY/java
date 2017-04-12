package com.sixth.sport.service;

import java.util.List;

import com.sixth.sport.domain.Guild;
import com.sixth.sport.domain.Systemddl;

public interface GuildService {


	/**
	 * 通过Id查询对象
	 * 
	 * @param id
	 * @return
	 */
	public Guild findById(String id);

	/**
	 * 通过keyword查询对应的值
	 * 
	 * @param keyword
	 * @return
	 */
	public List<Systemddl> findByKeyword(String keyword);

	/**
	 * 修改
	 * 
	 * @param guildname
	 * @param guildtime
	 * @param guildcommon
	 * @param guildis
	 * @param guildremark
	 * @param id
	 * @return
	 */
	public boolean updateGuild(String guildname, String guildtime, String guildcommon,
			String guildis, String guildremark, int id);

	public boolean delGuilds(String[] idss);

	/**
	 * 添加数据
	 * 
	 * @param guildname
	 * @param guildtime
	 * @param guildcommon
	 * @param guildis
	 * @param guildremark
	 * @return
	 */
	public boolean addGuild(String guildname, String guildtime, String guildcommon,
			String guildis, String guildremark);

	/**
	 * 通过Id删除
	 * 
	 * @param parseInt
	 * @return
	 */
	public boolean deleteGuildById(int parseInt);

	/**
	 * 显示班次列表
	 * 
	 * @param guildname
	 * @param end
	 * @param start
	 * 
	 * @return
	 */
	public List<Guild> findGuild(String guildname, int start, int end);

	/**
	 * 获取总页数
	 * 
	 * @return
	 */
	public int getItemCount();

}
