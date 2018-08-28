package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.EquipmentSubTypeUnion;
import com.energyman.dao.EquipmentSubTypeUnionDao;
import com.energyman.service.IEquipmentSubTypeUnionService;

@Service
public class EquipmentSubTypeUnionService implements IEquipmentSubTypeUnionService {

	@Autowired
	EquipmentSubTypeUnionDao equipmentSubTypeUnionDao;
	
	@Override
	public List<EquipmentSubTypeUnion> findEquipmentSubTypeUnionResult(Integer equipmentSubType_state) {
		// TODO Auto-generated method stub
		return equipmentSubTypeUnionDao.selectEquipmentSubTypeUnionResult(equipmentSubType_state);
	}
	
	
	
}
