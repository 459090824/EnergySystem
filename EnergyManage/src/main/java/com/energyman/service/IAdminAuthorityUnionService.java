package com.energyman.service;

import java.util.List;

import com.energyman.bean.AdminAuthorityUnion;

public interface IAdminAuthorityUnionService {

	/**
	 * ͨ������Աid���ҹ���Ա��Ȩ��
	 * @param systemadminid
	 * @return
	 */
	List<AdminAuthorityUnion> findAdminAuthorityByAdmin(Integer systemadminid);
}
