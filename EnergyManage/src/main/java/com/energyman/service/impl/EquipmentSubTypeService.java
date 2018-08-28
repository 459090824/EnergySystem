package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.EquipmentSubType;
import com.energyman.dao.EquipmentSubTypeDao;
import com.energyman.service.IEquipmentSubTypeService;

@Service
public class EquipmentSubTypeService implements IEquipmentSubTypeService{
	
	@Autowired
	private EquipmentSubTypeDao equipmentSubTypeDao;

	@Override
	public EquipmentSubType getEquipmentSubTypeById(Integer equipmentSubType_ID) {
		// TODO Auto-generated method stub
		return equipmentSubTypeDao.selectByPrimaryKey(equipmentSubType_ID);
	}

	@Override
	public boolean updateEquipmentSubType(EquipmentSubType record) {
		// TODO Auto-generated method stub
		int res=equipmentSubTypeDao.updateByPrimaryKeySelective(record);
		if(res > 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean deleteEquipmentSubType(Integer equipmentSubType_ID) {
		// TODO Auto-generated method stub
		int res=equipmentSubTypeDao.deleteByPrimaryKey(equipmentSubType_ID);
		if(res > 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean addEquipmentSubType(EquipmentSubType record) {
		// TODO Auto-generated method stub
		int res=equipmentSubTypeDao.insert(record);
		if(res > 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<EquipmentSubType> findAllEquipmentSubType(Integer equipmentSubType_state) {
		// TODO Auto-generated method stub
		List<EquipmentSubType> equipmentSubTypes=equipmentSubTypeDao.selectAllEquipmentSubType(equipmentSubType_state);
		return equipmentSubTypes;
	}

	@Override
	public List<EquipmentSubType> findEquipmentSubTypeByEquipmentType(Integer equipmentType_ID,
			Integer equipmentSubType_state) {
		// TODO Auto-generated method stub
		return equipmentSubTypeDao.selectEquipmentSubTypeByEquipmentType(equipmentType_ID, equipmentSubType_state);
	}
}
