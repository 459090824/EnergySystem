package com.energyman.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.SystemEquipmentType;
import com.energyman.dao.SystemEquipmentTypeDao;
import com.energyman.service.ISystemEquipmentTypeService;

@Service
public class SystemEquipmentTypeService implements ISystemEquipmentTypeService{

	@Autowired
	SystemEquipmentTypeDao systemEquipmentTypeDao;
	
	@Override
	public SystemEquipmentType getSystemEquipmentTypeById(Integer systemEquipmentType_ID) {
		// TODO Auto-generated method stub
		return systemEquipmentTypeDao.selectByPrimaryKey(systemEquipmentType_ID);
	}

	@Override
	public boolean addSystemEquipmentType(SystemEquipmentType record) {
		// TODO Auto-generated method stub
		int result=systemEquipmentTypeDao.insert(record);
		if(result > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean updateSystemEquipmentType(SystemEquipmentType record) {
		// TODO Auto-generated method stub
		int result=systemEquipmentTypeDao.updateByPrimaryKeySelective(record);
		if(result > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean deleteSystemEquipmentType(Integer systemEquipmentType_ID) {
		// TODO Auto-generated method stub
		int result=systemEquipmentTypeDao.deleteByPrimaryKey(systemEquipmentType_ID);
		if(result > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public List<SystemEquipmentType> findAllSystemEquipmentType(Integer systemEquipmentState_ID) {
		// TODO Auto-generated method stub
		return systemEquipmentTypeDao.selectAllSystemEquipmentType(systemEquipmentState_ID);
	}

}
