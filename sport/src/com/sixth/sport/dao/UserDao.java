package com.sixth.sport.dao;

import java.util.List;

import com.sixth.sport.domain.SpoUser;

public interface UserDao {
	/**
	 * ��ʾ�û��б�
	 * 
	 * @param username
	 * 
	 * @return
	 */
	public List<SpoUser> findUser(String username, int start, int end);

	/**
	 * ��ȡ��ҳ��
	 * 
	 * @return
	 */

	public int getItemCount();

	/**
	 * ͨ��Idɾ��
	 * 
	 * @param parseInt
	 * @return
	 */
	public boolean deleteUserById(int id);

	/**
	 * ����û�
	 * 
	 * @param params
	 * @return
	 */
	public boolean addUser(List<Object> params);

	/**
	 * ͨ��Id��ѯ����
	 * 
	 * @param params
	 * @return
	 */
	public SpoUser findById(List<Object> params);

	/**
	 * ���±���
	 * 
	 * @param params
	 * @return
	 */
	public boolean updateUser(List<Object> params);

	public boolean delUsers(String[] ids);

}
