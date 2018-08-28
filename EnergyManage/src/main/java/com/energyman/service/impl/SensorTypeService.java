package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.SensorType;
import com.energyman.dao.SensorTypeDao;
import com.energyman.service.ISensorTypeService;

@Service
public class SensorTypeService implements ISensorTypeService{
	
	@Autowired
	SensorTypeDao sensorTypeDao;
	
	@Override
	public SensorType getSensorTypeById(Integer sensorType_ID) {
		// TODO Auto-generated method stub
		return sensorTypeDao.selectByPrimaryKey(sensorType_ID);
	}

	@Override
	public boolean addSensorType(SensorType record) {
		// TODO Auto-generated method stub
		int result=sensorTypeDao.insert(record);
		if(result > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean updateSensorType(SensorType record) {
		// TODO Auto-generated method stub
		int reslut=sensorTypeDao.updateByPrimaryKeySelective(record);
		if(reslut > 0){
			return true;
		}else {
			return false;
		}		
	}

	@Override
	public boolean deleteSensorType(Integer sensorType_ID) {
		// TODO Auto-generated method stub
		int result=sensorTypeDao.deleteByPrimaryKey(sensorType_ID);
		if(result > 0){
			return true;
		}else{
			return false;
		}	
	}

	@Override
	public List<SensorType> findAllSensorType() {
		// TODO Auto-generated method stub
		return sensorTypeDao.selectAllSensorType();
	}

}
