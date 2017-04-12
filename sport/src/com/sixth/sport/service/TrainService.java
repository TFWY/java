package com.sixth.sport.service;

import java.util.List;

import com.sixth.sport.domain.Spor_train;
import com.sixth.sport.domain.Systemddl;

public interface TrainService {
	
	int getItemcount();

	/**
	 * ��ʾ��ѵ��Ϣ�б�
	 * 
	 * @param username
	 * @param end
	 * @param start
	 * 
	 * @return
	 */
	List<Spor_train> findtrain(String trainnum,int star,int end);

	/**
	 * ��ȡ��ҳ��
	 * 
	 * @return
	 */
	List<Systemddl> findByKeyword(String keyword);

	/**
	 * �������
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
	boolean updateTrain(String trainnum, String trainname, String trainteacher,
			String trainSchool, String trainaddress, String traintime,
			String remark, String id);

	/**
	 * ͨ��Idɾ��
	 * 
	 * @param parseInt
	 * @return
	 */
	boolean deleteTrainById(int parseInt);

	/**
	 * ͨ��Id��ѯ����
	 * 
	 * @param editId
	 * @return
	 */
	Spor_train findById(String editId);
	
	/**
	 * ����ɾ��
	 * 
	 */
	boolean delTrains(String[] idss);

}
