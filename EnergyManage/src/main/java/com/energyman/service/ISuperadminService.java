package com.energyman.service;

import com.energyman.bean.Superadmin;


public interface ISuperadminService {
	
	/**
	 * ͨ����������Աid�õ���������Ա��Ϣ
	 * @param  superadminid
	 * @return
	 * @author RenYang
	 */
	public Superadmin getSuperadminById(Integer superadminid);
	/**
	 * ͨ����������Աid���³�������Ա��Ϣ
	 * @param  record
	 * @return
	 * @author RenYang
	 */
	public boolean updateSuperadmin(Superadmin record);
}
