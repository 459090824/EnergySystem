package com.energyman.service;

import java.util.List;

import com.energyman.bean.AdminFunctionAuthority;

public interface IAdminFunctionAuthorityService {
	
	/**
	 * ���һ����̨�������ж�Ӧ��Ȩ��
	 * @return
	 */
	List<AdminFunctionAuthority> findAdminFunctionAuthorityListResult();
}
