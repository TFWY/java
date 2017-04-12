package com.sixth.sport.dao;

import java.util.List;

import com.sixth.sport.domain.ClassInf;

public interface ClassDao {
	
	/**0
	 * 
	 * ��ʾ�û��б�
	 * 
	 * @param username
	 * 
	 * @return
	 */
	public List<ClassInf> findClass(String ClassId, int start, int end);

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
	public boolean deleteClassById(int id);

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
	public ClassInf findById(List<Object> params);

	/**
	 * ���±���
	 * 
	 * @param params
	 * @return
	 */
	public boolean updateClass(List<Object> params);

	public boolean delUsers(String[] ids);

}
