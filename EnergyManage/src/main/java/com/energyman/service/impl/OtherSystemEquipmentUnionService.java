package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.OtherSystemEquipmentUnion;
import com.energyman.dao.OtherSystemEquipmentUnionDao;
import com.energyman.service.IOtherSystemEquipmentUnionService;

@Service
public class OtherSystemEquipmentUnionService implements IOtherSystemEquipmentUnionService{

	@Autowired
	OtherSystemEquipmentUnionDao otherSystemEquipmentUnionDao;
	
	@Override
	public List<OtherSystemEquipmentUnion> findOtherSystemEquipmentUnionResult(Integer stateID) {
		// TODO Auto-generated method stub
		return otherSystemEquipmentUnionDao.selectOtherSystemEquipmentUnionResult(stateID);
	}

}
