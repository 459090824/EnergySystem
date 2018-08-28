package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.Authority;
import com.energyman.dao.AuthorityMapper;
import com.energyman.service.IAuthorityService;

@Service
public class AuthorityService  implements IAuthorityService{

	@Autowired
	AuthorityMapper authorityMapper;
	
	@Override
	public Authority getAuthorityById(Integer authorityid) {
		// TODO Auto-generated method stub
		return authorityMapper.selectByPrimaryKey(authorityid);
	}

	@Override
	public boolean updateAuthority(Authority record) {
		// TODO Auto-generated method stub
		int res=authorityMapper.updateByPrimaryKey(record);
		if(res > 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean addAuthority(Authority record) {
		// TODO Auto-generated method stub
		int res=authorityMapper.insert(record);
		if(res > 0){
			return true;
		}else{
			return false;
		}	
	}

	@Override
	public boolean deleteAdmin(Integer authorityid) {
		// TODO Auto-generated method stub
		int res=authorityMapper.deleteByPrimaryKey(authorityid);
		if(res > 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<Authority> findAllAuthority() {
		// TODO Auto-generated method stub
		List<Authority> authorities=authorityMapper.selectAllAuthority();
		return authorities;
	}

	@Override
	public boolean updateAuthoritySelecttive(Authority record) {
		// TODO Auto-generated method stub
		int res=authorityMapper.updateByPrimaryKeySelective(record);
		if(res > 0){
			return true;
		}else{
			return false;
		}	
	}

}
