package com.energyman.dao;

import java.util.List;

import com.energyman.bean.AdminAuthorityUnion;

public interface AdminAuthorityUnionDao {
	
	/**
	 * ͨ������Աid���ҹ���Ա��Ȩ��
	 * @param systemadminid
	 * @return
	 */
	List<AdminAuthorityUnion> selectAdminAuthorityByAdmin(Integer systemadminid);
}
