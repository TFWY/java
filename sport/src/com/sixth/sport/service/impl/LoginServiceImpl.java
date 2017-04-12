package com.sixth.sport.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.sixth.sport.dao.LoginDao;
import com.sixth.sport.dao.impl.LoginDaoImpl;
import com.sixth.sport.domain.SpoUser;
import com.sixth.sport.service.LoginService;

public class LoginServiceImpl implements LoginService {
	
	private LoginDao loginDao;
	

	public LoginServiceImpl()
	{
		loginDao=new LoginDaoImpl();
	}
	
	@Override
	public boolean login(String username, String password) {
		List<Object> params=new ArrayList<Object>();
		params.add(username);
		SpoUser user=loginDao.login(params);
		if(user!=null)
		{
			if(password.equals(user.getPassword()))
			{
				return true;
			}
		}
		return false;
	}

}
