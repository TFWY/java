package com.sixth.sport.dao;

import java.util.List;

import com.sixth.sport.domain.Guild;

public interface GuildDao {

	/**
	 * ���ָ����Ϣ
	 * 
	 * @param params
	 * @return
	 */
	public boolean addGuild(List<Object> params);

	public boolean delGuilds(String[] idss);

	/**
	 * ͨ��Idɾ��
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteGuildById(int id);

	/**
	 * ͨ��Id��ѯ����
	 * 
	 * @param params
	 * @return
	 */
	public Guild findById(List<Object> params);

	/**
	 * ��ȡ��ҳ��
	 * 
	 * @return
	 */
	public int getItemCount();

	/**
	 * ���±���
	 * 
	 * @param params
	 * @return
	 */
	public boolean updateGuild(List<Object> params);

	/**
	 * ��ʾָ����Ϣ�б�
	 * 
	 * @param guildname
	 * 
	 * @return
	 */
	public List<Guild> findGuild(String guildname, int start, int end);

}
