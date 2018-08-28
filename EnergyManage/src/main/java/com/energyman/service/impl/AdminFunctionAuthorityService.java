package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.AdminFunctionAuthority;
import com.energyman.dao.AdminFunctionAuthorityDao;
import com.energyman.service.IAdminFunctionAuthorityService;

@Service
public class AdminFunctionAuthorityService implements IAdminFunctionAuthorityService {

	@Autowired
	AdminFunctionAuthorityDao adminFunctionAuthorityDao;
	
	@Override
	public List<AdminFunctionAuthority> findAdminFunctionAuthorityListResult() {
		// TODO Auto-generated method stub
		return adminFunctionAuthorityDao.selectAdminFunctionAuthorityListResult();
	}

}
