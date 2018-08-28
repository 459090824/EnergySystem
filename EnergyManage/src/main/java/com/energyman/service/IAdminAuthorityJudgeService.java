package com.energyman.service;

import com.energyman.bean.AdminAuthorityJudge;

public interface IAdminAuthorityJudgeService {

	/**
	 * 对登录的管理员进行权限的判断
	 * @param systemadminid
	 * @param adminfunctionid
	 * @param authoritytypeid
	 * @param authoritystatus
	 * @return
	 */
	AdminAuthorityJudge findAdminFunctionAuthorityByAdmin(Integer systemadminid,Integer adminfunctionid,
			Integer authoritytypeid,Integer authoritystatus);
}
