package com.sixth.sport.service.impl;


import java.util.ArrayList;
import java.util.List;
import com.sixth.sport.dao.SystemDao;
import com.sixth.sport.dao.impl.SystemDaoImpl;
import com.sixth.sport.domain.Systemddl;
import com.sixth.sport.service.SystemService;

public class SystemServiceImpl implements SystemService {
	
	
	private  SystemDao systemDao;
	
	
	public SystemServiceImpl()
	{
		systemDao=new SystemDaoImpl();
	}
	

	@Override
	public List<Systemddl> findKeyWord() {
		// TODO Auto-generated method stub
		return systemDao.findKeyWord();
	}


	@Override
	public List<Systemddl> findByKeyWord(String keyword) {
		List<Object> params=new ArrayList<Object>();
		params.add(keyword);
		return systemDao.findByKeyWord(params);
	}


	@Override
	public void saveSystemddl(String keywordnew, String[] itemname) {
		List<Object> params=new ArrayList<Object>();
		for(int i=0;i<itemname.length;i++)
		{
			params.add(keywordnew);
			params.add(itemname[i]);
			params.add(new Integer(i+1));
			systemDao.saveSystemddl(params);
			params.clear();
		}
		
	}


	@Override
	public void updateSystemddl(String keywordnew, String[] itemname) {
		List<Object> params=new ArrayList<Object>();
		for(int i=0;i<itemname.length;i++ )
		{
			params.add(itemname[i]);
			params.add(new Integer(i+1));
			params.add(keywordnew);
			systemDao.updateSystemddl(params);
			params.clear();
		}
		
	}


	@Override
	public String findByddlName(String ddlcode, String keyword) {
		List<Object> params=new ArrayList<Object>();
		params.add(ddlcode);
		params.add(keyword);
		return systemDao.findByddlName(params);
	}


	@Override
	public boolean delSystemddl(int delid) {
		
		return systemDao.delSystemddl(delid);
		
		
	}
	
	
}
