package com.sixth.sport.dao;

import java.util.List;

import com.sixth.sport.domain.Guild;

public interface GuildDao {

	/**
	 * 添加指南信息
	 * 
	 * @param params
	 * @return
	 */
	public boolean addGuild(List<Object> params);

	public boolean delGuilds(String[] idss);

	/**
	 * 通过Id删除
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteGuildById(int id);

	/**
	 * 通过Id查询对象
	 * 
	 * @param params
	 * @return
	 */
	public Guild findById(List<Object> params);

	/**
	 * 获取总页数
	 * 
	 * @return
	 */
	public int getItemCount();

	/**
	 * 更新保存
	 * 
	 * @param params
	 * @return
	 */
	public boolean updateGuild(List<Object> params);

	/**
	 * 显示指南信息列表
	 * 
	 * @param guildname
	 * 
	 * @return
	 */
	public List<Guild> findGuild(String guildname, int start, int end);

}
