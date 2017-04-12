package com.sixth.sport.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sixth.sport.dao.TrainDao;
import com.sixth.sport.db.JdbcUtils;
import com.sixth.sport.domain.Spor_train;

public class TrainDaoimpl implements TrainDao {

	JdbcUtils dbUtils;
	public TrainDaoimpl()
	{
		dbUtils=new JdbcUtils();
	}
	@Override
	public List<Spor_train> findtrain(String trainnum, int star, int end) {
		List<Spor_train> trainList= null;
		try {
			List<Object> param=new ArrayList<Object>();
			param.add(star);
			param.add(end);
			String sql ="select *from train ";
			dbUtils.getConnection();
			StringBuffer sBuffer=new StringBuffer(sql);
			if(trainnum!=null)
			{
				sBuffer.append(" where trainnum like ");
				sBuffer.append("'%"+trainnum+"%'");
			}
			sBuffer.append(" limit ?,?");
			trainList=dbUtils.findMoreRefResult(sBuffer.toString(), param, Spor_train.class);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dbUtils.releaseConn();
		}
		
		return trainList;
	}

	@Override
	public int getItemcount() {
	    int count=0;
		try {
			String sqlString="SELECT COUNT(*) as mycount FROM train";
			dbUtils.getConnection();
			Map<String, Object> map=dbUtils.findSimpleResult(sqlString, null);
			if(map!=null)
			{
				count=Integer.parseInt(map.get("mycount").toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dbUtils.releaseConn();
		}
		return count;
	}
	@Override
	public boolean addTrain(List<Object> params) {
		boolean flag=false;
		try {
			String sql="INSERT INTO  train(trainnum,trainname,trainteacher,trainSchool,trainaddress,traintime,remark) VALUES (?,?,?,?,?,?,?)";
			dbUtils.getConnection();
			flag=dbUtils.updateByPreparedStatement(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dbUtils.releaseConn();
		}
		return flag;
	}
	@Override
	public boolean updateTrain(List<Object> params) {
		boolean flag=false;
		try {
			String sql="update train set trainnum=?,trainname=?,trainteacher=?,trainSchool=?,trainaddress=?,traintime=?,remark=? where id=?";
			dbUtils.getConnection();
			flag=dbUtils.updateByPreparedStatement(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dbUtils.releaseConn();
		}
		return flag;
	}
	@Override
	public boolean deleteTrainById(int id) {
		boolean flag=false;
		try {
			String sql="DELETE FROM train WHERE id="+id;
			dbUtils.getConnection();
			flag=dbUtils.updateByPreparedStatement(sql, null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			dbUtils.releaseConn();
		}
		return flag;
	}
	@Override
	public Spor_train findById(List<Object> params) {
		Spor_train tra = null;
		try {
			String sql="select * from train where id=?";
			dbUtils.getConnection();
			tra=dbUtils.findSimpleRefResult(sql, params, Spor_train.class);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dbUtils.releaseConn();
		}
		return tra;
	}
	@Override
	public boolean delTrains(String[] idss) {
		boolean flag=false;
		try {
			dbUtils.getConnection();
			//System.out.println(idss.length);
			String[] sql=new String [idss.length];
			if(idss!=null)
			{
			
				for (int i = 0; i < idss.length; i++) {
					sql[i]="DELETE FROM train WHERE id="+Integer.parseInt(idss[i]);
				}
			}
			flag=dbUtils.deleteByBatch(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dbUtils.releaseConn();
		}
		return flag;
	}
}
