package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.EnergyType;
import com.energyman.dao.EnergyTypeDao;
import com.energyman.service.IEnergyTypeService;

@Service
public class EnergyTypeService implements IEnergyTypeService{
	
	@Autowired
	EnergyTypeDao energyTypeDao;

	@Override
	public EnergyType getEnergyTypeById(Integer energyType_ID) {
		// TODO Auto-generated method stub
		return energyTypeDao.selectByPrimaryKey(energyType_ID);
	}

	@Override
	public boolean addEnergyType(EnergyType record) {
		// TODO Auto-generated method stub
		int result=energyTypeDao.insert(record);
		if(result > 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateEnergyType(EnergyType record) {
		// TODO Auto-generated method stub
		int result=energyTypeDao.updateByPrimaryKeySelective(record);
		if(result > 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean deleteEnergyType(Integer energyType_ID) {
		// TODO Auto-generated method stub
		int result=energyTypeDao.deleteByPrimaryKey(energyType_ID);
		if(result > 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<EnergyType> findAllEnergyType() {
		// TODO Auto-generated method stub
		List<EnergyType> energyTypes=energyTypeDao.selectAllEnergyType();
		return energyTypes;
	}

	@Override
	public int findCountEnergyType() {
		// TODO Auto-generated method stub
		return energyTypeDao.selectCountEnergyType();
	}

}
