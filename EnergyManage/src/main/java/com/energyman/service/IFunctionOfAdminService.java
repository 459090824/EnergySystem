package com.energyman.service;

import java.util.List;

import com.energyman.bean.FunctionOfAdmin;

public interface IFunctionOfAdminService {
	
	/**
	 * 根据用户权限，判断显示用户后台功能
	 * @param SystemAdminID
	 * @param FunctionLevel
	 * @param ParentFunction
	 * @param FunctionStatus
	 * @param IsMenu
	 * @param AuthorityTypeID
	 * @return
	 */
	public List<FunctionOfAdmin> selectFunctionOfAdminByAdmin(Integer SystemAdminID, Integer FunctionLevel, 
			Integer ParentFunction, Integer FunctionStatus, String IsMenu, Integer AuthorityTypeID);
}
