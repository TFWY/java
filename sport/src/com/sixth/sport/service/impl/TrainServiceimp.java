package com.sixth.sport.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.sixth.sport.dao.TrainDao;
import com.sixth.sport.dao.impl.TrainDaoimpl;
import com.sixth.sport.domain.Spor_train;
import com.sixth.sport.domain.Systemddl;
import com.sixth.sport.service.SystemService;
import com.sixth.sport.service.TrainService;

public class TrainServiceimp implements TrainService {

TrainDao traindao;
	
	SystemService sysService;
	public TrainServiceimp()
	{
		traindao=new TrainDaoimpl();
		sysService=new SystemServiceImpl();
	}
	@Override
	public List<Spor_train> findtrain(String trainnum, int star, int end) {
		List<Spor_train> sporTrainslis=new ArrayList<Spor_train>();
		Spor_train train;
		List<Spor_train> list=traindao.findtrain(trainnum,star,end);
		for (Spor_train sporTrain : list) {
			train=new Spor_train();
			train.setId(sporTrain.getId());
			train.setTrainname(sporTrain.getTrainname());
			train.setTrainnum(sporTrain.getTrainnum());
			train.setTrainSchool(sporTrain.getTrainSchool()!=null&&!sporTrain.getTrainSchool().equals("")?sysService.findByddlName(sporTrain.getTrainSchool(), "培训校区"):"");
			train.setTrainteacher(sporTrain.getTrainteacher());
			train.setTrainaddress(sporTrain.getTrainaddress());
			train.setRemark(sporTrain.getRemark());
			train.setTraintime(sporTrain.getTraintime());
			sporTrainslis.add(train);
		}
		return sporTrainslis;
	}

	@Override
	public int getItemcount() {
		// TODO Auto-generated method stub
		return traindao.getItemcount();
	}
	
	public List<Systemddl> findByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return sysService.findByKeyWord(keyword);
	}
	@Override
	public boolean addTrain(String trainnum, String trainname,
			String trainteacher, String trainSchool, String trainaddress,
			String traintime, String remark) {
		List<Object> params=new ArrayList<Object>();
		params.add(trainnum);
		params.add(trainname);
		params.add(trainteacher);
		params.add(trainSchool);
		params.add(trainaddress);
		params.add(traintime);
		params.add(remark);
		return traindao.addTrain(params);
	}
	@Override
	public boolean updateTrain(String trainnum, String trainname,
			String trainteacher, String trainSchool, String trainaddress,
			String traintime, String remark, String id) {
		List<Object> params=new ArrayList<Object>();
		params.add(trainnum);
		params.add(trainname);
		params.add(trainteacher);
		params.add(trainSchool);
		params.add(trainaddress);
		params.add(traintime);
		params.add(remark);
		params.add(id);
		return traindao.updateTrain(params);

	}
	@Override
	public boolean deleteTrainById(int id) {
		return traindao.deleteTrainById(id);
	}
	@Override
	public Spor_train findById(String editId) {
		Spor_train tra=new Spor_train();
		int id=Integer.parseInt(editId);
		List<Object> params=new ArrayList<Object>();
		params.add(id);
		Spor_train tras=traindao.findById(params);
		tra.setId(tras.getId());
		tra.setTrainnum(tras.getTrainnum());
		tra.setTrainname(tras.getTrainname());
		tra.setTrainteacher(tras.getTrainteacher());
		tra.setTrainSchool(tras.getTrainSchool()!=null&&!tras.getTrainSchool().equals("")?sysService.findByddlName(tras.getTrainSchool(), "培训校区"):"");
		tra.setTrainaddress(tras.getTrainaddress());
		tra.setTraintime(tras.getTraintime());
		tra.setRemark(tras.getRemark());
	   return tra;
	}
	@Override
	public boolean delTrains(String[] idss) {
		// TODO Auto-generated method stub
		 return traindao.delTrains(idss);
	}

}
