package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.EquipmentType;
import com.energyman.dao.EquipmentTypeDao;
import com.energyman.service.IEquipmentTypeService;

@Service
public class EquipmentTypeService implements IEquipmentTypeService{
	
	@Autowired
	private EquipmentTypeDao equipmentTypeDao;

	@Override
	public EquipmentType getEquipmentTypeById(Integer equipmentType_ID) {
		// TODO Auto-generated method stub
		return equipmentTypeDao.selectByPrimaryKey(equipmentType_ID);
	}

	@Override
	public boolean updateEquipmentType(EquipmentType record) {
		// TODO Auto-generated method stub
		int res=equipmentTypeDao.updateByPrimaryKeySelective(record);
		if(res > 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean deleteEquipmentType(Integer equipmentType_ID) {
		// TODO Auto-generated method stub
		int res=equipmentTypeDao.deleteByPrimaryKey(equipmentType_ID);
		if(res > 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean addEquipmentType(EquipmentType record) {
		// TODO Auto-generated method stub
		int res=equipmentTypeDao.insert(record);
		if(res > 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<EquipmentType> findAllEquipmentType(Integer equipmentType_state) {
		// TODO Auto-generated method stub
		List<EquipmentType> equipmentTypes=equipmentTypeDao.selectAllEquipmentType(equipmentType_state);
		return equipmentTypes;
	}
	
}
