package com.energyman.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.Sensor;
import com.energyman.dao.SensorDao;
import com.energyman.service.ISensorService;

@Service
public class SensorService implements ISensorService {

	@Autowired
	SensorDao sensorDao;
	
	@Override
	public Sensor getSensorById(Integer sensor_ID) {
		// TODO Auto-generated method stub
		return sensorDao.selectByPrimaryKey(sensor_ID);
	}

	@Override
	public Sensor getEquipment(Sensor record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateSensor(Sensor record) {
		// TODO Auto-generated method stub
		int reslut=sensorDao.updateByPrimaryKeySelective(record);
		if(reslut > 0){
			return true;
		}else {
			return false;
		}		
	}

	@Override
	public boolean addSensor(Sensor record) {
		// TODO Auto-generated method stub
		int result=sensorDao.insert(record);
		if(result > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean deleteSensor(Integer sensor_ID) {
		// TODO Auto-generated method stub
		int result=sensorDao.deleteByPrimaryKey(sensor_ID);
		if(result > 0){
			return true;
		}else {
			return false;
		}		
	}

}
