package com.energyman.service;

import com.energyman.bean.Superadmin;


public interface ISuperadminService {
	
	/**
	 * 通过超级管理员id得到超级管理员信息
	 * @param  superadminid
	 * @return
	 * @author RenYang
	 */
	public Superadmin getSuperadminById(Integer superadminid);
	/**
	 * 通过超级管理员id更新超级管理员信息
	 * @param  record
	 * @return
	 * @author RenYang
	 */
	public boolean updateSuperadmin(Superadmin record);
}
