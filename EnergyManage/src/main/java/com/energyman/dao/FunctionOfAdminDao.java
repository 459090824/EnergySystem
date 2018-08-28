package com.energyman.dao;

import java.util.List;

import com.energyman.bean.FunctionOfAdmin;

public interface FunctionOfAdminDao {
	
	
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
	public List<FunctionOfAdmin> findFunctionOfAdminByAdmin(Integer SystemAdminID, Integer FunctionLevel, 
			Integer ParentFunction, Integer FunctionStatus, String IsMenu, Integer AuthorityTypeID);
}
