package com.sixth.sport.dao.impl;

import java.util.List;

import com.sixth.sport.dao.LoginDao;
import com.sixth.sport.db.JdbcUtils;
import com.sixth.sport.domain.SpoUser;

public class LoginDaoImpl implements LoginDao {
	
	private JdbcUtils jdbcUtils;
	
	public LoginDaoImpl()
	{
		jdbcUtils=new JdbcUtils();
	}

	@Override
	public SpoUser login(List<Object> params) {
		SpoUser user = null;
		try {
			String sql="SELECT su.password FROM  sporter su WHERE su.username=?";
			//�õ�Connection����
			jdbcUtils.getConnection();
			//��ɾ�Ĳ�
			user=jdbcUtils.findSimpleRefResult(sql, params, SpoUser.class);
			if(user!=null)
			{
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			jdbcUtils.releaseConn();
		}
		return null;
	}

}
