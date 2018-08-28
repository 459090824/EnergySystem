package com.energyman.dao;

import java.util.List;

import com.energyman.bean.AdminAuthorityUnion;

public interface AdminAuthorityUnionDao {
	
	/**
	 * 通过管理员id查找管理员的权限
	 * @param systemadminid
	 * @return
	 */
	List<AdminAuthorityUnion> selectAdminAuthorityByAdmin(Integer systemadminid);
}
