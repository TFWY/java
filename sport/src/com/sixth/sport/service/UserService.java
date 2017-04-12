package com.sixth.sport.service;

import java.util.List;

import com.sixth.sport.domain.SpoUser;
import com.sixth.sport.domain.Systemddl;

public interface UserService {
	/**
	 * 显示用户列表
	 * 
	 * @param username
	 * @param end
	 * @param start
	 * 
	 * @return
	 */
	public List<SpoUser> findUser(String username, int start, int end);

	/**
	 * 获取总页数
	 * 
	 * @return
	 */
	public int getItemCount();

	/**
	 * 通过Id删除
	 * 
	 * @param parseInt
	 * @return
	 */
	public boolean deleteUserById(int parseInt);

	/**
	 * 通过keyword查询对应的值
	 * 
	 * @param keyword
	 * @return
	 */
	public List<Systemddl> findByKeyword(String keyword);

	/**
	 * 添加数据
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
	 * 通过Id查询对象
	 * 
	 * @param editId
	 * @return
	 */
	public SpoUser findById(String editId);

	/**
	 * 修改
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
