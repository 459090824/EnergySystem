package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.EquipmentDispatchUnion;
import com.energyman.dao.EquipmentDispatchUnionMapper;
import com.energyman.service.IEquipmentDispatchUnionService;

@Service
public class EquipmentDispatchUnionService implements IEquipmentDispatchUnionService{

	@Autowired
	EquipmentDispatchUnionMapper equipmentDispatchUnionMapper;
	
	@Override
	public List<EquipmentDispatchUnion> findEquipmentDispatchUnionResult() {
		// TODO Auto-generated method stub
		return equipmentDispatchUnionMapper.selectEquipmentDispatchUnionResult();
	}

}
