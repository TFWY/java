package com.sixth.sport.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.sixth.sport.dao.UserDao;
import com.sixth.sport.dao.impl.UserDaoImpl;
import com.sixth.sport.domain.SpoUser;
import com.sixth.sport.domain.Systemddl;
import com.sixth.sport.service.SystemService;
import com.sixth.sport.service.UserService;

public   class UserServiceImpl implements UserService {
	
	
	private UserDao userDao;
	
	private SystemService systemService;
	
	public UserServiceImpl()
	{
		userDao=new UserDaoImpl();
		systemService=new SystemServiceImpl();
	}

	@Override
	public List<SpoUser> findUser(String username,int start, int end) {
		List<SpoUser> users = new ArrayList<SpoUser>();
		SpoUser spoUser;
		List<SpoUser> list=userDao.findUser(username,start,end);
		for (SpoUser spo : list) {
			spoUser=new SpoUser();
			spoUser.setId(spo.getId());
			spoUser.setUsername(spo.getUsername());
			spoUser.setSex(spo.getSex()!=null&&!spo.getSex().equals("")?systemService.findByddlName(spo.getSex(),"性别"):"");
		    spoUser.setBrithday(spo.getBrithday());
			spoUser.setPhone(spo.getPhone());
		    spoUser.setEmail(spo.getEmail());
		    users.add(spoUser);
		}
		return users;
	}

	@Override
	public int getItemCount() {
		
		return userDao.getItemCount();
	}

	@Override
	public boolean deleteUserById(int id) {
		
		return userDao.deleteUserById(id);
	}

	@Override
	public List<Systemddl> findByKeyword(String keyword) {
		
		return systemService.findByKeyWord(keyword);
	}

	@Override
	public boolean addUser(String username, String password, String sexId,
			String birthday, String phone, String email, String remark) {
		List<Object> params=new ArrayList<Object>();
		params.add(username);
		params.add(password);
		params.add(sexId);
		params.add(birthday);
		params.add(phone);
		params.add(email);
		params.add(remark);
		return userDao.addUser(params);
	}

	@Override
	public SpoUser findById(String editId) {
		SpoUser spo=new SpoUser();
		int id=Integer.parseInt(editId);
		List<Object> params=new ArrayList<Object>();
		params.add(id);
		SpoUser users=userDao.findById(params);
		spo.setId(users.getId());
		spo.setUsername(users.getUsername());
		spo.setPassword(users.getPassword());
		spo.setSex(users.getSex()!=null&&!users.getSex().equals("")?systemService.findByddlName(users.getSex(), "性别"):"");
		spo.setBrithday(users.getBrithday());
		spo.setPhone(users.getPhone());
		spo.setEmail(users.getEmail());
		spo.setRemark(users.getRemark());
	   return spo;
	}

	@Override
	public boolean updateUser(String username, String password, String sexId,
			String birthday, String phone, String email, String remark,
			String id) {
		List<Object> params=new ArrayList<Object>();
		params.add(username);
		params.add(password);
		params.add(sexId);
		params.add(birthday);
		params.add(phone);
		params.add(email);
		params.add(remark);
		params.add(id);
		return userDao.updateUser(params);
	}

	@Override
	public boolean delUsers(String[] ids) {
		return userDao.delUsers(ids);
	}

}
