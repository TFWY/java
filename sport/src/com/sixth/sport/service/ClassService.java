package com.sixth.sport.service;

import java.util.List;



import com.sixth.sport.domain.ClassInf;


public interface ClassService {
	/**
	 * ��ʾ�û��б�
	 * 
	 * @param username
	 * @param end
	 * @param start
	 * 
	 * @return
	 */
	List<ClassInf> findClass(String username, int start, int end);

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
	 * ͨ��keyword��ѯ��Ӧ��ֵ
	 * 
	 * @param keyword
	 * @return
	 */
	public List<ClassInf> findByKeyword(String keyword);

	/**
	 * �������
	 * 
	 * @param username
	 * @param password
	 * @param sexId
	 * @param birthday
	 * @param phone
	 * @param email
	 * @param remark
	 * @return
	 */
	public boolean addClass(String classId, String className, String classtime,
			String classcommon, String classremark);
	
	/**
	 * ͨ��Id��ѯ����
	 * 
	 * @param editId
	 * @return
	 */
	public ClassInf findById(String editId);

	/**
	 * �޸�
	 * 
	 * @param username
	 * @param password
	 * @param sexId
	 * @param birthday
	 * @param phone
	 * @param email
	 * @param remark
	 * @param id
	 * @return
	 */
	public boolean updateClass(String classname, String classid, String classtime,
			String classcommon, String classremark,String id);

	public boolean delUsers(String[] ids);



	
}
