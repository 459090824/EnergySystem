package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.Equipment;
import com.energyman.dao.EquipmentDao;
import com.energyman.service.IEquipmentService;

@Service
public class EquipmentService implements IEquipmentService {
	
	@Autowired
	EquipmentDao equipmenDao;

	@Override
	public Equipment getEquipmentById(Integer equipment_ID) {
		// TODO Auto-generated method stub
		return equipmenDao.selectByPrimaryKey(equipment_ID);
	}

	@Override
	public Equipment getEquipment(Equipment record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateEquipment(Equipment record) {
		// TODO Auto-generated method stub
		int res=equipmenDao.updateByPrimaryKeySelective(record);
		if(res > 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean addEquipment(Equipment record) {
		// TODO Auto-generated method stub
		int res=equipmenDao.insert(record);
		if(res > 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean deleteEquipment(Integer equipment_ID) {
		// TODO Auto-generated method stub
		int res=equipmenDao.deleteByPrimaryKey(equipment_ID);
		if(res > 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<Equipment> findAllEquipment() {
		// TODO Auto-generated method stub
		List<Equipment> equipments=equipmenDao.selectAllEquipment();
		return equipments;
	}

	@Override
	public int countEquipmentTotal() {
		// TODO Auto-generated method stub
		return equipmenDao.selectCountTotal();
	}

	@Override
	public int countByState(Integer state_ID) {
		// TODO Auto-generated method stub
		return equipmenDao.selectCountByState(state_ID);
	}

	@Override
	public int selectCountByType(Integer equipmentType_ID) {
		// TODO Auto-generated method stub
		return equipmenDao.selectNumByType(equipmentType_ID);
	}

	@Override
	public int selectCountBySubType(Integer equipmentSubType_ID) {
		// TODO Auto-generated method stub
		return equipmenDao.selectNumBySubType(equipmentSubType_ID);
	}

	@Override
	public int selectCountByAddr(Integer addr_ID) {
		// TODO Auto-generated method stub
		return equipmenDao.selectNumByAddr(addr_ID);
	}

	@Override
	public Equipment getEquipmentByEquipmentCode(Integer equipment_Code) {
		// TODO Auto-generated method stub
		return equipmenDao.selectByEquipmentCode(equipment_Code);
	}
	
	
	
}
