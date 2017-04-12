package com.sixth.sport.service;

import java.util.List;

import com.sixth.sport.domain.SpoUser;
import com.sixth.sport.domain.Systemddl;

public interface UserService {
	/**
	 * ��ʾ�û��б�
	 * 
	 * @param username
	 * @param end
	 * @param start
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
	public boolean deleteUserById(int parseInt);

	/**
	 * ͨ��keyword��ѯ��Ӧ��ֵ
	 * 
	 * @param keyword
	 * @return
	 */
	public List<Systemddl> findByKeyword(String keyword);

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
	public boolean addUser(String username, String password, String sexId,
			String birthday, String phone, String email, String remark);

	/**
	 * ͨ��Id��ѯ����
	 * 
	 * @param editId
	 * @return
	 */
	public SpoUser findById(String editId);

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
	public boolean updateUser(String username, String password, String sexId,
			String birthday, String phone, String email, String remark,
			String id);

	public boolean delUsers(String[] ids);

}
