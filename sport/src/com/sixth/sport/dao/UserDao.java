package com.sixth.sport.dao;

import java.util.List;

import com.sixth.sport.domain.SpoUser;

public interface UserDao {
	/**
	 * 显示用户列表
	 * 
	 * @param username
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
	public boolean deleteUserById(int id);

	/**
	 * 添加用户
	 * 
	 * @param params
	 * @return
	 */
	public boolean addUser(List<Object> params);

	/**
	 * 通过Id查询对象
	 * 
	 * @param params
	 * @return
	 */
	public SpoUser findById(List<Object> params);

	/**
	 * 更新保存
	 * 
	 * @param params
	 * @return
	 */
	public boolean updateUser(List<Object> params);

	public boolean delUsers(String[] ids);

}
