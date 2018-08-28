package com.energyman.service;

import java.util.List;

import com.energyman.bean.AdminFunctionAuthority;

public interface IAdminFunctionAuthorityService {
	
	/**
	 * 获得一个后台功能所有对应的权限
	 * @return
	 */
	List<AdminFunctionAuthority> findAdminFunctionAuthorityListResult();
}
