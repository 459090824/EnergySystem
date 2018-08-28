package com.energyman.dao;

import com.energyman.bean.AdminAuthorityJudge;

public interface AdminAuthorityJudgeDao {
	
	/**
	 * 对登录的管理员进行权限的判断
	 * @param systemadminid
	 * @param adminfunctionid
	 * @param authoritytypeid
	 * @param authoritystatus
	 * @return
	 */
	AdminAuthorityJudge selectAdminFunctionAuthorityByAdmin(Integer systemadminid,Integer adminfunctionid,
			Integer authoritytypeid,Integer authoritystatus);
}
