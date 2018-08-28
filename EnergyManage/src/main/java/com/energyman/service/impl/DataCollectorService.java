package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.DataCollector;
import com.energyman.dao.DataCollectorDao;
import com.energyman.service.IDataCollectorService;

@Service
public class DataCollectorService implements IDataCollectorService {

	@Autowired
	DataCollectorDao dataCollectorDao;
	
	@Override
	public DataCollector getDataCollectorById(Integer collection_ID) {
		// TODO Auto-generated method stub
		return dataCollectorDao.selectByPrimaryKey(collection_ID);
	}

	@Override
	public DataCollector getDataCollector(DataCollector record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateDataCollector(DataCollector record) {
		// TODO Auto-generated method stub
		int res=dataCollectorDao.updateByPrimaryKeySelective(record);
		if(res > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean addDataCollector(DataCollector record) {
		// TODO Auto-generated method stub
		int res=dataCollectorDao.insert(record);
		if(res > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean deleteDataCollector(Integer collection_ID) {
		// TODO Auto-generated method stub
		int res=dataCollectorDao.deleteByPrimaryKey(collection_ID);
		if(res > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public List<DataCollector> findAllDataCollector() {
		// TODO Auto-generated method stub
		return dataCollectorDao.selectAllDataCollector();
	}

}
