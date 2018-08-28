package com.energyman.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.EquipmentCountUnion;
import com.energyman.dao.EquipmentCountUnionDao;
import com.energyman.service.IEquipmentCountUnionService;

@Service
public class EquipmentCountUnionService implements IEquipmentCountUnionService{

	@Autowired
	EquipmentCountUnionDao equipmentCountUnionDao;

	@Override
	public int findcountEquipmentByRoom(Integer room_ID) {
		// TODO Auto-generated method stub
		return equipmentCountUnionDao.countEquipmentByRoom(room_ID);
	}

	@Override
	public int findcountEquipmentByBuilding(Integer build_ID) {
		// TODO Auto-generated method stub
		return equipmentCountUnionDao.countEquipmentByBuilding(build_ID);
	}

	@Override
	public int findcountEquipmentByArea(Integer region_ID) {
		// TODO Auto-generated method stub
		return equipmentCountUnionDao.countEquipmentByArea(region_ID);
	}

	@Override
	public EquipmentCountUnion findEquipmentByCode(Integer equipment_Code) {
		// TODO Auto-generated method stub
		return equipmentCountUnionDao.selectEquipmentByCode(equipment_Code);
	}
}
