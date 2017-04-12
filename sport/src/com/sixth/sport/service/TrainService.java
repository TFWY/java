package com.sixth.sport.service;

import java.util.List;

import com.sixth.sport.domain.Spor_train;
import com.sixth.sport.domain.Systemddl;

public interface TrainService {
	
	int getItemcount();

	/**
	 * 显示培训信息列表
	 * 
	 * @param username
	 * @param end
	 * @param start
	 * 
	 * @return
	 */
	List<Spor_train> findtrain(String trainnum,int star,int end);

	/**
	 * 获取总页数
	 * 
	 * @return
	 */
	List<Systemddl> findByKeyword(String keyword);

	/**
	 * 添加数据
	 * 
	 * @param username
	 * @param password
	 * @param trainId
	 * @param birthday
	 * @param phone
	 * @param email
	 * @param remark
	 * @return
	 */
	boolean addTrain(String trainnum, String trainname, String trainteacher,
			String trainSchool, String trainaddress, String traintime,
			String remark);

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
	boolean updateTrain(String trainnum, String trainname, String trainteacher,
			String trainSchool, String trainaddress, String traintime,
			String remark, String id);

	/**
	 * 通过Id删除
	 * 
	 * @param parseInt
	 * @return
	 */
	boolean deleteTrainById(int parseInt);

	/**
	 * 通过Id查询对象
	 * 
	 * @param editId
	 * @return
	 */
	Spor_train findById(String editId);
	
	/**
	 * 批量删除
	 * 
	 */
	boolean delTrains(String[] idss);

}
