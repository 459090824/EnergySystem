package com.energyman.service;

import com.energyman.bean.AdminAuthorityJudge;

public interface IAdminAuthorityJudgeService {

	/**
	 * �Ե�¼�Ĺ���Ա����Ȩ�޵��ж�
	 * @param systemadminid
	 * @param adminfunctionid
	 * @param authoritytypeid
	 * @param authoritystatus
	 * @return
	 */
	AdminAuthorityJudge findAdminFunctionAuthorityByAdmin(Integer systemadminid,Integer adminfunctionid,
			Integer authoritytypeid,Integer authoritystatus);
}
