package com.energyman.service;

import java.util.List;

import com.energyman.bean.FunctionOfAdmin;

public interface IFunctionOfAdminService {
	
	/**
	 * �����û�Ȩ�ޣ��ж���ʾ�û���̨����
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
