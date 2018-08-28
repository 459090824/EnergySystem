package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.EquipmentDispatch;
import com.energyman.dao.EquipmentDispatchDao;
import com.energyman.service.IEquipmentDispatchService;

@Service
public class EquipmentDispatchService implements IEquipmentDispatchService{

	@Autowired
	EquipmentDispatchDao equipmentDispatchDao;
	
	@Override
	public EquipmentDispatch getEquipmentDispatchById(Integer dispatch_ID) {
		// TODO Auto-generated method stub
		return equipmentDispatchDao.selectByPrimaryKey(dispatch_ID);
	}

	@Override
	public EquipmentDispatch getEquipmentDispatch(EquipmentDispatch record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateEquipmentDispatch(EquipmentDispatch record) {
		// TODO Auto-generated method stub
		int res = equipmentDispatchDao.updateByPrimaryKeySelective(record);
		if(res > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean addEquipmentDispatch(EquipmentDispatch record) {
		// TODO Auto-generated method stub
		int res=equipmentDispatchDao.insert(record);
		if(res > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean deleteEquipmentDispatch(Integer dispatch_ID) {
		// TODO Auto-generated method stub
		int res=equipmentDispatchDao.deleteByPrimaryKey(dispatch_ID);
		if(res > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public List<EquipmentDispatch> findAllEquipmentDispatch() {
		// TODO Auto-generated method stub
		return equipmentDispatchDao.selectAllEquipmentDispatch();
	}

}
