package com.sixth.sport.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sixth.sport.dao.UserDao;
import com.sixth.sport.db.JdbcUtils;
import com.sixth.sport.domain.SpoUser;

public class UserDaoImpl implements UserDao {
	
	private JdbcUtils jdbcUtils;
	
	public UserDaoImpl()
	{
		jdbcUtils=new JdbcUtils();
	}
	
	@Override
	public List<SpoUser> findUser(String username,int start, int end) {
		List<SpoUser> list = null;
		try {
			List<Object> params=new ArrayList<Object>();
			params.add(start);
			params.add(end);
			String  sql="select * from sporter  ";//
			StringBuffer sb=new StringBuffer(sql);
			if(username!=null)
			{
				sb.append(" where username like");
				sb.append(" '%"+username+"%'");
			}
			sb.append("limit ?,?");
			jdbcUtils.getConnection();
			list=jdbcUtils.findMoreRefResult(sb.toString(), params, SpoUser.class);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			jdbcUtils.releaseConn();
		}
		return list;
	}


	@Override
	public int getItemCount() {
		int count=0;
		try {
			String sql="SELECT COUNT(*) as mycount FROM sporter ";
			jdbcUtils.getConnection();
		Map<String, Object> map=jdbcUtils.findSimpleResult(sql, null);
		if(map!=null)
		{
			count=Integer.parseInt(map.get("mycount").toString());
		}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			jdbcUtils.releaseConn();
		}
		return count;
	}


	@Override
	public boolean deleteUserById(int id) {
	     boolean flag=false;
		try {
			String sql="DELETE FROM sporter WHERE id="+id;
			jdbcUtils.getConnection();
			flag=jdbcUtils.updateByPreparedStatement(sql, null);
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			jdbcUtils.releaseConn();
		}
		return flag;
	}


	@Override
	public boolean addUser(List<Object> params) {
		boolean flag=false;
		try {
			String sql="INSERT INTO  sporter(username,password,sex,brithday,phone,email,remark) VALUES (?,?,?,?,?,?,?)";
			jdbcUtils.getConnection();
			flag=jdbcUtils.updateByPreparedStatement(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			jdbcUtils.releaseConn();
		}
		return flag;
	}


	@Override
	public SpoUser findById(List<Object> params) {
		SpoUser user = null;
		try {
			String sql="select * from sporter where id=?";
			jdbcUtils.getConnection();
			user=jdbcUtils.findSimpleRefResult(sql, params, SpoUser.class);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			jdbcUtils.releaseConn();
		}
		return user;
	}


	@Override
	public boolean updateUser(List<Object> params) {
		boolean flag=false;
		try {
			String sql="update sporter  set username=?,password=?,sex=?,brithday=?,phone=?,email=?,remark=? where id=?";
			jdbcUtils.getConnection();
			flag=jdbcUtils.updateByPreparedStatement(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			jdbcUtils.releaseConn();
		}
		return flag;
	}


	@Override
	public boolean delUsers(String[] ids) {
		boolean flag=false;
		try {
			jdbcUtils.getConnection();
			//System.out.println(ids.length);
			String[] sql=new String [ids.length];
			if(ids!=null)
			{
			
				for (int i = 0; i < ids.length; i++) {
					sql[i]="DELETE FROM sporter WHERE id="+Integer.parseInt(ids[i]);
				}
			}
			flag=jdbcUtils.deleteByBatch(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			jdbcUtils.releaseConn();
		}
		return flag;
	}
}
