package com.sixth.sport.dao;

import java.util.List;

import com.sixth.sport.domain.Spor_train;



public interface TrainDao {

	/**
	 * 显示培训信息列表
	 * 
	 * @param trainnum
	 * 
	 * @return
	 */
	List<Spor_train> findtrain(String trainnum, int star, int end);

	/**
	 * 获取总页数
	 * 
	 * @return
	 */
	int getItemcount();

	/**
	 * 添加培训信息
	 * 
	 * @param params
	 * @return
	 */
	boolean addTrain(List<Object> params);

	/**
	 * 更新保存
	 * 
	 * @param params
	 * @return
	 */
	boolean updateTrain(List<Object> params);

	/**
	 * 通过Id删除
	 * 
	 * @param parseInt
	 * @return
	 */
	boolean deleteTrainById(int id);


	/**
	 * 通过Id查询对象
	 * 
	 * @param params
	 * @return
	 */
	Spor_train findById(List<Object> params);
	/**
	 * 批量删除
	 * @param idss
	 * @return
	 */

	boolean delTrains(String[] idss);
}
