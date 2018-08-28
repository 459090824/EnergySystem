package com.energyman.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.filefilter.TrueFileFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.AdminAuthority;
import com.energyman.bean.AdminAuthorityUnion;
import com.energyman.dao.AdminAuthorityDao;
import com.energyman.service.IAdminAuthorityService;

@Service
public class AdminAuthorityService implements IAdminAuthorityService {
	
	@Autowired
	AdminAuthorityDao adminAuthorityDao;
	
	@Override
	public AdminAuthority getAdminAuthorityById(Integer noteid) {
		// TODO Auto-generated method stub
		return adminAuthorityDao.selectByPrimaryKey(noteid);
	}

	@Override
	public boolean addAdminAuthority(AdminAuthority record) {
		// TODO Auto-generated method stub
		int result=adminAuthorityDao.insert(record);
		if(result > 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean deleteAdminAuthority(Integer noteid) {
		// TODO Auto-generated method stub
		int result=adminAuthorityDao.deleteByPrimaryKey(noteid);
		if(result > 0){
			return true;
		}else{
			return false;
		}		
	}

	
	
	
	@Override
	public List<AdminAuthorityUnion> selectAdminFunctionAuthorityByAdminId(Integer systemadminid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean batchDelete(List<Integer> noteids) {
		// TODO Auto-generated method stub
		int result =adminAuthorityDao.batchDelete(noteids);
		if(result == noteids.size()){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean saveRoleOwnAuthorityList(List<AdminAuthority> authorities) {
		// TODO Auto-generated method stub
		int result = adminAuthorityDao.batchInsert(authorities);
		if(result == authorities.size()){
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public List<Integer> findAuthorityIdByAdminIdAndAuthorityId(Integer authorityid, Integer systemadminid) {
		// TODO Auto-generated method stub
		List<AdminAuthority> adminAuthorities=adminAuthorityDao.selectAuthorityIdByAdminIdAndAuthorityId(authorityid, systemadminid);
		List<Integer> list=new ArrayList<Integer>();
		for(AdminAuthority adminAuthority:adminAuthorities){
			list.add(adminAuthority.getNoteid());
		}
		return list;
	}

}
