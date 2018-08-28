package com.energyman.service;

import java.util.List;

import com.energyman.bean.AdminAuthorityUnion;

public interface IAdminAuthorityUnionService {

	/**
	 * 通过管理员id查找管理员的权限
	 * @param systemadminid
	 * @return
	 */
	List<AdminAuthorityUnion> findAdminAuthorityByAdmin(Integer systemadminid);
}
