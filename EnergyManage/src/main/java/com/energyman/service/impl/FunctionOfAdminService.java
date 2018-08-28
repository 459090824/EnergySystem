package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.FunctionOfAdmin;
import com.energyman.dao.FunctionOfAdminDao;
import com.energyman.service.IFunctionOfAdminService;

@Service
public class FunctionOfAdminService implements IFunctionOfAdminService{

	@Autowired
	FunctionOfAdminDao functionOfAdminDao;
	
	@Override
	public List<FunctionOfAdmin> selectFunctionOfAdminByAdmin(Integer SystemAdminID, Integer FunctionLevel,
			Integer ParentFunction, Integer FunctionStatus, String IsMenu, Integer AuthorityTypeID) {
		// TODO Auto-generated method stub
		return functionOfAdminDao.findFunctionOfAdminByAdmin(SystemAdminID, FunctionLevel, ParentFunction, 
				FunctionStatus, IsMenu, AuthorityTypeID);
	}

}
