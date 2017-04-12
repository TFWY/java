package com.sixth.sport.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.sixth.sport.dao.ClassDao;
import com.sixth.sport.dao.impl.ClassDaoImpl;
import com.sixth.sport.domain.ClassInf;
import com.sixth.sport.service.ClassService;

public class ClassServiceImpl implements ClassService {

	private ClassDao classDao;
	
	public ClassServiceImpl()
	{
		classDao = new ClassDaoImpl();
	}
	@Override
	public List<ClassInf> findClass(String ClassId, int start, int end) {
		List<ClassInf> inf = new ArrayList<ClassInf>();
		ClassInf classInf;
		List<ClassInf> list=classDao.findClass(ClassId,start,end);
		for (ClassInf spo : list) {
			classInf=new ClassInf();
			classInf.setId(spo.getId());
			classInf.setClassId(spo.getClassId());
			classInf.setClassName(spo.getClassName());
			classInf.setClasstime(spo.getClasstime());
			classInf.setClasscommon(spo.getClasscommon());
			classInf.setClassremark(spo.getClassremark());
			inf.add(classInf);
		}
		return inf;
	}

	@Override
	public int getItemCount() {
		
		return classDao.getItemCount();
	}

	@Override
	public List<ClassInf> findByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ClassInf findById(String Id) {
		ClassInf inf=new ClassInf();
		int id=Integer.parseInt(Id);
		List<Object> params=new ArrayList<Object>();
		params.add(id);
		ClassInf infs=classDao.findById(params);
		inf.setId(infs.getId());
		inf.setClassId(infs.getClassId());
		inf.setClassName(infs.getClassName());
		inf.setClasstime(infs.getClasstime());
		inf.setClasscommon(infs.getClasscommon());
		inf.setClassremark(infs.getClassremark());
	   return inf;
	}

	@Override
	public boolean delUsers(String[] ids) {
		// TODO Auto-generated method stub
		return classDao.delUsers(ids);
	}
	@Override
	public boolean addClass(String classId, String className, String classtime,
			String classcommon, String classremark) {
		List<Object> params=new ArrayList<Object>();
		params.add(classId);
		params.add(className);
		params.add(classtime);
		params.add(classcommon);
		params.add(classremark);
		return classDao.addUser(params);
	}
	@Override
	public boolean updateClass(String classname, String classid,
			String classtime, String classcommon, String classremark, String id) {
		List<Object> params=new ArrayList<Object>();
		params.add(classname);
		params.add(classid);
		params.add(classtime);
		params.add(classcommon);
		params.add(classremark);
		params.add(id);
		return classDao.updateClass(params);
	}
	
	@Override
	public boolean deleteClassById(int id) {
		// TODO Auto-generated method stub
		return  classDao.deleteClassById(id);
	}

}
