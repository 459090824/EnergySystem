package com.energyman.dao;

import com.energyman.bean.AdminAuthorityJudge;

public interface AdminAuthorityJudgeDao {
	
	/**
	 * �Ե�¼�Ĺ���Ա����Ȩ�޵��ж�
	 * @param systemadminid
	 * @param adminfunctionid
	 * @param authoritytypeid
	 * @param authoritystatus
	 * @return
	 */
	AdminAuthorityJudge selectAdminFunctionAuthorityByAdmin(Integer systemadminid,Integer adminfunctionid,
			Integer authoritytypeid,Integer authoritystatus);
}
