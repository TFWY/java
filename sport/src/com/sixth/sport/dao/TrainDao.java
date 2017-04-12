package com.sixth.sport.dao;

import java.util.List;

import com.sixth.sport.domain.Spor_train;



public interface TrainDao {

	/**
	 * ��ʾ��ѵ��Ϣ�б�
	 * 
	 * @param trainnum
	 * 
	 * @return
	 */
	List<Spor_train> findtrain(String trainnum, int star, int end);

	/**
	 * ��ȡ��ҳ��
	 * 
	 * @return
	 */
	int getItemcount();

	/**
	 * �����ѵ��Ϣ
	 * 
	 * @param params
	 * @return
	 */
	boolean addTrain(List<Object> params);

	/**
	 * ���±���
	 * 
	 * @param params
	 * @return
	 */
	boolean updateTrain(List<Object> params);

	/**
	 * ͨ��Idɾ��
	 * 
	 * @param parseInt
	 * @return
	 */
	boolean deleteTrainById(int id);


	/**
	 * ͨ��Id��ѯ����
	 * 
	 * @param params
	 * @return
	 */
	Spor_train findById(List<Object> params);
	/**
	 * ����ɾ��
	 * @param idss
	 * @return
	 */

	boolean delTrains(String[] idss);
}
