package com.energyman.dao;

import java.util.List;

import com.energyman.bean.AdminFunctionAuthority;

public interface AdminFunctionAuthorityDao {
	
	/**
	 * ���һ����̨�������ж�Ӧ��Ȩ��
	 * @return
	 */
	List<AdminFunctionAuthority> selectAdminFunctionAuthorityListResult();
}
