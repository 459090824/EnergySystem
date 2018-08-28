package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.SystemEquipmentSubTypeUnion;
import com.energyman.dao.SystemEquipmentSubTypeUnionDao;
import com.energyman.service.ISystemEquipmentSubTypeUnionService;

@Service
public class SystemEquipmentSubTypeUnionService implements ISystemEquipmentSubTypeUnionService{

	@Autowired
	SystemEquipmentSubTypeUnionDao systemEquipmentSubTypeUnionDao;
	
	@Override
	public List<SystemEquipmentSubTypeUnion> findSystemEquipmentSubTypeUnionResult(Integer systemEquipmentSubState_ID) {
		// TODO Auto-generated method stub
		return systemEquipmentSubTypeUnionDao.selectSystemEquipmentSubTypeUnionResult(systemEquipmentSubState_ID);
	}

}
