package com.sixth.sport.dao;

import java.util.List;

import com.sixth.sport.domain.SpoUser;

public interface LoginDao {
	/**
	 * ��½
	 * 
	 * @param params
	 * @return SpoUser
	 */
	public SpoUser login(List<Object> params);

}
