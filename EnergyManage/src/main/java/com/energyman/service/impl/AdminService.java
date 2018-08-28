package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.Admin;
import com.energyman.dao.AdminMapper;
import com.energyman.service.IAdminService;

@Service
public class AdminService implements IAdminService {

	@Autowired
	AdminMapper adminMapper;
	
	@Override
	public Admin getAdminById(Integer systemadminid) {
		// TODO Auto-generated method stub
		return adminMapper.selectByPrimaryKey(systemadminid);
	}

	@Override
	public Admin getAdmin(Admin record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateAdmin(Admin record) {
		// TODO Auto-generated method stub
		int result=adminMapper.updateByPrimaryKeySelective(record);
		if(result > 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean addAdmin(Admin record) {
		// TODO Auto-generated method stub
		int result=adminMapper.insert(record);
		if(result > 0){
			return true;
		}else {
			return false;
		}		
	}

	@Override
	public boolean deleteAdmin(Integer systemadminid) {
		// TODO Auto-generated method stub
		int result=adminMapper.deleteByPrimaryKey(systemadminid);
		if(result > 0){
			return true;
		}else{
			return false;
		}
	}


	@Override
	public List<Admin> findAllAdmin() {
		// TODO Auto-generated method stub
		List<Admin> admins=adminMapper.selectAllAdmin();
		return admins;
	}

	@Override
	public Admin findAdmin(String username, String password) {
		// TODO Auto-generated method stub
		return adminMapper.selectAdmin(username, password);
	}

}
