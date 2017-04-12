package com.sixth.sport.dao;

import java.util.List;

import com.sixth.sport.domain.ClassInf;

public interface ClassDao {
	
	/**0
	 * 
	 * 显示用户列表
	 * 
	 * @param username
	 * 
	 * @return
	 */
	public List<ClassInf> findClass(String ClassId, int start, int end);

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
	public boolean deleteClassById(int id);

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
	public ClassInf findById(List<Object> params);

	/**
	 * 更新保存
	 * 
	 * @param params
	 * @return
	 */
	public boolean updateClass(List<Object> params);

	public boolean delUsers(String[] ids);

}
