package com.energyman.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.Superadmin;
import com.energyman.dao.SuperadminMapper;
import com.energyman.service.ISuperadminService;


@Service
public class SuperadminService implements ISuperadminService {
	
	@Autowired
	SuperadminMapper superadminMapper;
	
	@Override
	public Superadmin getSuperadminById(Integer superadminid) {
		// TODO Auto-generated method stub
		return superadminMapper.selectByPrimaryKey(superadminid);
	}

	@Override
	public boolean updateSuperadmin(Superadmin record) {
		// TODO Auto-generated method stub
		int result=superadminMapper.updateByPrimaryKeySelective(record);
		if(result > 0){
			return true;
		}else{
			return false;
		}		
	}
	
}
