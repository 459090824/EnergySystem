package com.energyman.dao;

import java.util.List;

import com.energyman.bean.AdminFunctionAuthority;

public interface AdminFunctionAuthorityDao {
	
	/**
	 * 获得一个后台功能所有对应的权限
	 * @return
	 */
	List<AdminFunctionAuthority> selectAdminFunctionAuthorityListResult();
}
