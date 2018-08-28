package com.energyman.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.OtherSystemEquipment;
import com.energyman.dao.OtherSystemEquipmentDao;
import com.energyman.service.IOtherSystemEquipmentService;

@Service
public class OtherSystemEquipmentService implements IOtherSystemEquipmentService{

	@Autowired
	OtherSystemEquipmentDao otherSystemEquipmentDao;
	
	@Override
	public OtherSystemEquipment getOtherSystemEquipmentById(Integer systemEquipmentID) {
		// TODO Auto-generated method stub
		return otherSystemEquipmentDao.selectByPrimaryKey(systemEquipmentID);
	}

	@Override
	public boolean updateOtherSystemEquipment(OtherSystemEquipment record) {
		// TODO Auto-generated method stub
		int res = otherSystemEquipmentDao.updateByPrimaryKeySelective(record);
		if(res > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean addOtherSystemEquipment(OtherSystemEquipment record) {
		// TODO Auto-generated method stub
		int res = otherSystemEquipmentDao.insert(record);
		if(res > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean deleteOtherSystemEquipment(Integer systemEquipmentID) {
		// TODO Auto-generated method stub
		int res = otherSystemEquipmentDao.deleteByPrimaryKey(systemEquipmentID);
		if(res > 0){
			return true;
		}else{
			return false;
		}		
	}

}
