package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.SensorUnion;
import com.energyman.dao.SensorUnionMapper;
import com.energyman.service.ISensorUnionService;

@Service
public class SensorUnionService implements ISensorUnionService{

	@Autowired
	SensorUnionMapper sensorUnionMapper;
	
	@Override
	public List<SensorUnion> findAllSensorUnion(Integer state_ID) {
		// TODO Auto-generated method stub
		return sensorUnionMapper.selectSensorUnionResult(state_ID);
	}

}
