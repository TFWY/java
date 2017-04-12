package com.sixth.sport.dao.impl;

import java.util.List;
import java.util.Map;

import com.sixth.sport.dao.SystemDao;
import com.sixth.sport.db.JdbcUtils;
import com.sixth.sport.domain.Systemddl;

public class SystemDaoImpl implements SystemDao {

	private JdbcUtils jdbcUtils;

	public SystemDaoImpl() {
		jdbcUtils = new JdbcUtils();
	}

	@Override
	public List<Systemddl> findKeyWord() {
		List<Systemddl> systemddls;
		try {
			String sql = "SELECT DISTINCT sp.keyword FROM sys sp";
			jdbcUtils.getConnection();
			systemddls = jdbcUtils
					.findMoreRefResult(sql, null, Systemddl.class);
			if (systemddls != null) {
				return systemddls;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtils.releaseConn();
		}
		return null;
	}

	@Override
	public List<Systemddl> findByKeyWord(List<Object> params) {
		List<Systemddl> systems = null;
		try {
			String sql = "SELECT * FROM sys WHERE keyword=?";
			jdbcUtils.getConnection();
			systems = jdbcUtils.findMoreRefResult(sql, params, Systemddl.class);
			/*for (Systemddl s : systems) {
				System.out.println(s.getDdlname());
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtils.releaseConn();
		}
		return systems;
	}

	@Override
	public void saveSystemddl(List<Object> params) {
		try {
			String sql = "INSERT INTO  sys(keyword,ddlname,ddlcode) VALUES(?,?,?)";
			jdbcUtils.getConnection();
			jdbcUtils.updateByPreparedStatement(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtils.releaseConn();
		}

	}

	@Override
	public void updateSystemddl(List<Object> params) {
		try {
			String sql = "update sys set ddlname=? where ddlcode=? and keyword=?";
			jdbcUtils.getConnection();
			boolean flag = jdbcUtils.updateByPreparedStatement(sql, params);
			if (!flag) {
				String sql1="INSERT INTO  sys(ddlname,ddlcode,keyword) VALUES(?,?,?)";
				jdbcUtils.updateByPreparedStatement(sql1, params);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtils.releaseConn();
		}

	}

	@Override
	public String findByddlName(List<Object> params) {
		String result = null;
		try {
			String sql = "select ddlname from sys where ddlcode=? and keyword=?";
			jdbcUtils.getConnection();
			Map<String, Object> map = jdbcUtils.findSimpleResult(sql, params);
			if (map != null) {
				result = (String) map.get("ddlname");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtils.releaseConn();
		}
		return result;
	}

	@Override
	public boolean delSystemddl(int delid) {
		boolean flag=false;
		try {
			String sql="DELETE FROM sys WHERE id="+delid;
			jdbcUtils.getConnection();
			flag=jdbcUtils.updateByPreparedStatement(sql, null);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			jdbcUtils.releaseConn();
		}
		return flag;
	}

}
