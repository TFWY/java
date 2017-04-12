package com.sixth.sport.service;

import java.util.List;

import com.sixth.sport.domain.Guild;
import com.sixth.sport.domain.Systemddl;

public interface GuildService {


	/**
	 * ͨ��Id��ѯ����
	 * 
	 * @param id
	 * @return
	 */
	public Guild findById(String id);

	/**
	 * ͨ��keyword��ѯ��Ӧ��ֵ
	 * 
	 * @param keyword
	 * @return
	 */
	public List<Systemddl> findByKeyword(String keyword);

	/**
	 * �޸�
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
	 * �������
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
	 * ͨ��Idɾ��
	 * 
	 * @param parseInt
	 * @return
	 */
	public boolean deleteGuildById(int parseInt);

	/**
	 * ��ʾ����б�
	 * 
	 * @param guildname
	 * @param end
	 * @param start
	 * 
	 * @return
	 */
	public List<Guild> findGuild(String guildname, int start, int end);

	/**
	 * ��ȡ��ҳ��
	 * 
	 * @return
	 */
	public int getItemCount();

}
