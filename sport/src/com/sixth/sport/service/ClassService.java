package com.sixth.sport.service;

import java.util.List;



import com.sixth.sport.domain.ClassInf;


public interface ClassService {
	/**
	 * 显示用户列表
	 * 
	 * @param username
	 * @param end
	 * @param start
	 * 
	 * @return
	 */
	List<ClassInf> findClass(String username, int start, int end);

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
	 * 通过keyword查询对应的值
	 * 
	 * @param keyword
	 * @return
	 */
	public List<ClassInf> findByKeyword(String keyword);

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
	public boolean addClass(String classId, String className, String classtime,
			String classcommon, String classremark);
	
	/**
	 * 通过Id查询对象
	 * 
	 * @param editId
	 * @return
	 */
	public ClassInf findById(String editId);

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
	public boolean updateClass(String classname, String classid, String classtime,
			String classcommon, String classremark,String id);

	public boolean delUsers(String[] ids);



	
}
