package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.AdminAuthorityUnion;
import com.energyman.dao.AdminAuthorityUnionDao;
import com.energyman.service.IAdminAuthorityUnionService;

@Service
public class AdminAuthorityUnionService implements IAdminAuthorityUnionService{
	
	@Autowired
	AdminAuthorityUnionDao adminAuthorityUnionDao;

	@Override
	public List<AdminAuthorityUnion> findAdminAuthorityByAdmin(Integer systemadminid) {
		// TODO Auto-generated method stub
		return adminAuthorityUnionDao.selectAdminAuthorityByAdmin(systemadminid);
	}
	
	
}
