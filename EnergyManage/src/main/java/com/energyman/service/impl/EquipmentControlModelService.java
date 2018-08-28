package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.EquipmentControlModel;
import com.energyman.dao.EquipmentControlModelDao;
import com.energyman.service.IEquipmentControlModelService;

@Service
public class EquipmentControlModelService implements IEquipmentControlModelService{

	@Autowired
	EquipmentControlModelDao equipmentControlModelDao;
	
	@Override
	public EquipmentControlModel getEquipmentControlModelById(Integer equipmentControlModel_ID) {
		// TODO Auto-generated method stub
		return equipmentControlModelDao.selectByPrimaryKey(equipmentControlModel_ID);
	}

	@Override
	public boolean addEquipmentControlModel(EquipmentControlModel record) {
		// TODO Auto-generated method stub
		int result=equipmentControlModelDao.insert(record);
		if(result > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean updateEquipmentControlModel(EquipmentControlModel record) {
		// TODO Auto-generated method stub
		int result=equipmentControlModelDao.updateByPrimaryKeySelective(record);
		if(result > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean deleteEquipmentControlModel(Integer equipmentControlModel_ID) {
		// TODO Auto-generated method stub
		int result=equipmentControlModelDao.deleteByPrimaryKey(equipmentControlModel_ID);
		if(result > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public List<EquipmentControlModel> findAllEquipmentControlModel() {
		// TODO Auto-generated method stub
		return equipmentControlModelDao.selectAllEquipmentControlModel();
	}

}
