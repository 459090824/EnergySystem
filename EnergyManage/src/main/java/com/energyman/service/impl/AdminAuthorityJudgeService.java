package com.energyman.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.AdminAuthorityJudge;
import com.energyman.dao.AdminAuthorityJudgeDao;
import com.energyman.service.IAdminAuthorityJudgeService;

@Service
public class AdminAuthorityJudgeService implements IAdminAuthorityJudgeService{

	@Autowired
	AdminAuthorityJudgeDao adminAuthorityJudgeDao;
	
	@Override
	public AdminAuthorityJudge findAdminFunctionAuthorityByAdmin(Integer systemadminid, Integer adminfunctionid,
			Integer authoritytypeid, Integer authoritystatus) {
		// TODO Auto-generated method stub
		return adminAuthorityJudgeDao.selectAdminFunctionAuthorityByAdmin(systemadminid, adminfunctionid, 
				authoritytypeid, authoritystatus);
	}

}
