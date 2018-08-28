package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.SystemEquipmentSubType;
import com.energyman.dao.SystemEquipmentSubTypeDao;
import com.energyman.service.ISystemEquipmentSubTypeService;

@Service
public class SystemEquipmentSubTypeService implements ISystemEquipmentSubTypeService{

	@Autowired
	SystemEquipmentSubTypeDao systemEquipmentSubTypeDao;
	
	@Override
	public SystemEquipmentSubType getSystemEquipmentSubTypeById(Integer systemEquipmentSubType_ID) {
		// TODO Auto-generated method stub
		return systemEquipmentSubTypeDao.selectByPrimaryKey(systemEquipmentSubType_ID);
	}

	@Override
	public boolean addSystemEquipmentSubType(SystemEquipmentSubType record) {
		// TODO Auto-generated method stub
		int res = systemEquipmentSubTypeDao.insert(record);
		if(res > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean updateSystemEquipmentSubType(SystemEquipmentSubType record) {
		// TODO Auto-generated method stub
		int res = systemEquipmentSubTypeDao.updateByPrimaryKeySelective(record);
		if(res > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean deleteSystemEquipmentSubType(Integer systemEquipmentSubType_ID) {
		// TODO Auto-generated method stub
		int res = systemEquipmentSubTypeDao.deleteByPrimaryKey(systemEquipmentSubType_ID);
		if(res > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public List<SystemEquipmentSubType> findAllSystemEquipmentSubType(Integer systemEquipmentSubState_ID) {
		// TODO Auto-generated method stub
		return systemEquipmentSubTypeDao.selectAllSystemEquipmentSubType(systemEquipmentSubState_ID);
	}

	@Override
	public List<SystemEquipmentSubType> selectSystemEquipmentSubTypeBySystemEquipmentType(
			Integer systemEquipmentType_ID,Integer systemEquipmentSubState_ID) {
		// TODO Auto-generated method stub
		return systemEquipmentSubTypeDao.selectSystemEquipmentSubTypeBySystemEquipmentType(systemEquipmentType_ID,systemEquipmentSubState_ID);
	}

}
