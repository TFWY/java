package com.sixth.sport.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sixth.sport.dao.ClassDao;
import com.sixth.sport.db.JdbcUtils;
import com.sixth.sport.domain.ClassInf;


public class ClassDaoImpl implements ClassDao {

	private JdbcUtils jdbcUtils;
	
	public ClassDaoImpl()
	{
		jdbcUtils=new JdbcUtils();
	}
	
	@Override
	public List<ClassInf> findClass(String classId, int start, int end) {
		List<ClassInf> list = null;
		try {
			List<Object> params=new ArrayList<Object>();
			params.add(start);
			params.add(end);
			String  sql="select * from spo_class  ";//
			StringBuffer sb=new StringBuffer(sql);
			if(classId!=null)
			{
				sb.append(" where classId like");
				sb.append(" '%"+classId+"%'");
			}
			sb.append("limit ?,?");
			jdbcUtils.getConnection();
			list=jdbcUtils.findMoreRefResult(sb.toString(), params, ClassInf.class);
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
			String sql="SELECT COUNT(*) as mycount FROM spo_class ";
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
	public boolean deleteClassById(int id) {
		boolean flag=false;
		try {
			String sql="DELETE FROM spo_class WHERE id="+id;
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
			String sql="INSERT INTO  spo_class(classId,className, classtime,classcommon,classremark) VALUES (?,?,?,?,?)";
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
	public ClassInf findById(List<Object> params) {
		ClassInf inf = null;
		try {
			String sql="select * from spo_class where id=?";
			jdbcUtils.getConnection();
			inf=jdbcUtils.findSimpleRefResult(sql, params, ClassInf.class);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			jdbcUtils.releaseConn();
		}
		return inf;
	}

	public boolean updateClass(List<Object> params) {
		boolean flag=false;
		try {
			String sql="update spo_class  set classId=?,className=?,classtime=?,classcommon=?,classremark=? where id=?";
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
					sql[i]="DELETE FROM spo_class WHERE id="+Integer.parseInt(ids[i]);
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
