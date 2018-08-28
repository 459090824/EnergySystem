package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.DataCollectorUnion;
import com.energyman.dao.DataCollectorUnionDao;
import com.energyman.service.IDataCollectorUnionService;

@Service
public class DataCollectorUnionService implements IDataCollectorUnionService{

	@Autowired
	DataCollectorUnionDao dataCollectorUnionDao;
	
	@Override
	public List<DataCollectorUnion> findAllDataCollectorUnion(Integer state_ID) {
		// TODO Auto-generated method stub
		return dataCollectorUnionDao.selectDataCollectorUnionResult(state_ID);
	}

	
}
