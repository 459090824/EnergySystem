package com.energyman.service;

import java.util.List;

import com.energyman.bean.Authority;

public interface IAuthorityService {
	/**通过authorityid获得权限信息
	 * @param authorityid
	 * @return
	 * @author RenYang
	 */
	public Authority getAuthorityById(Integer authorityid);
	
	/**
	 * 通过Authority对象更新非空权限信息
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean updateAuthoritySelecttive(Authority record);
	
	/**
	 * 通过Authority对象更新所有权限信息
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean updateAuthority(Authority record);
	
	/**
	 * 通过Authority对象增加权限
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean addAuthority(Authority record);
	
	/**
	 * 通过authorityid删除权限
	 * @param  authorityid
	 * @return
	 * @author RenYang
	 */
	public boolean deleteAdmin(Integer authorityid);
	
	/**
	 * 查询得到所有权限信息
	 * @param  
	 * @return
	 * @author RenYang
	 */
	public List<Authority> findAllAuthority();
}
