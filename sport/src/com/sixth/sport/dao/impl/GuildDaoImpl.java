package com.sixth.sport.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import com.sixth.sport.dao.GuildDao;
import com.sixth.sport.db.JdbcUtils;
import com.sixth.sport.domain.Guild;

public class GuildDaoImpl implements GuildDao {

private JdbcUtils jdbcUtils;
	
	public GuildDaoImpl(){
		
		jdbcUtils = new JdbcUtils();
		
	}
	@Override
	public boolean addGuild(List<Object> params) {
		boolean flag =false;
		String sql="insert into guilds(guildname,guildtime,guildcommon,guildis,guildremark) values (?,?,?,?,?)";
		jdbcUtils.getConnection();
		try {
			flag=jdbcUtils.updateByPreparedStatement(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbcUtils.releaseConn();
		}
		return flag;
	}

	@Override
	public boolean delGuilds(String[] ids) {
		boolean flag=false;
		try {
			jdbcUtils.getConnection();
			System.out.println(ids.length);
			String[] sql=new String [ids.length];
			if(ids!=null)
			{
			
				for (int i = 0; i < ids.length; i++) {
					sql[i]="DELETE FROM guilds WHERE id="+Integer.parseInt(ids[i]);
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

	@Override
	public boolean deleteGuildById(int id) {
		boolean flag =false;
		try {
		String sql ="delete from guilds where id ="+id;
		jdbcUtils.getConnection();
			flag =jdbcUtils.updateByPreparedStatement(sql, null);
		} catch (Exception e) {
		}finally{
			jdbcUtils.releaseConn();
		}
		return flag;
	}

	@Override
	public Guild findById(List<Object> params) {
		Guild user = null;
		try {
			String sql="select * from guilds where id=?";
			jdbcUtils.getConnection();
			user=jdbcUtils.findSimpleRefResult(sql, params, Guild.class);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			jdbcUtils.releaseConn();
		}
		return user;
	}

	@Override
	public List<Guild> findGuild(String Guildname, int start, int end) {
List<Guild> list = null;
		
		List<Object> params =new ArrayList<Object>();
		
		params.add(start);
		params.add(end);
		String sql ="select * from guilds " ;
		StringBuffer sb =new  StringBuffer(sql);
		if(Guildname!=null){
			sb.append("where guildname like");
			sb.append("'%"+Guildname+"%'");
		}
		sb.append("limit ?,?");
		jdbcUtils.getConnection();
		try {
			list =jdbcUtils.findMoreRefResult(sb.toString(),params,Guild.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbcUtils.releaseConn();
		}
		return list;
	}

	@Override
	public int getItemCount() {
		int count = 0;
		try{
		String sql="select count(*) as mycount from guilds " ;
		jdbcUtils.getConnection();
		Map<String,Object> map =jdbcUtils.findSimpleResult(sql, null);
		if(map!=null){
			count =Integer.parseInt(map.get("mycount").toString());
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			jdbcUtils.releaseConn();
		}
		return count;
	}

	@Override
	public boolean updateGuild(List<Object> params) {
		boolean flag=false;
		try {
			String sql="update guilds  set guildname=?,guildtime=?,guildcommon=?,guildis=?,guildremark=? where id=? ";
			jdbcUtils.getConnection();
			flag=jdbcUtils.updateByPreparedStatement(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			jdbcUtils.releaseConn();
		}
		return flag;
	}

}
