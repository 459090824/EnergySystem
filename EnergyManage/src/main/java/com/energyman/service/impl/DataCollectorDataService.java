package com.energyman.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.DataCollectorData;
import com.energyman.dao.DataCollectorDataDao;
import com.energyman.service.IDataCollectorDataService;

@Service
public class DataCollectorDataService implements IDataCollectorDataService{

	@Autowired
	DataCollectorDataDao dataCollectorDataDao;
	
	@Override
	public DataCollectorData getDataCollectorDataById(Integer collectonData_ID) {
		// TODO Auto-generated method stub
		return dataCollectorDataDao.selectByPrimaryKey(collectonData_ID);
	}

	@Override
	public DataCollectorData getDataCollectorData(DataCollectorData record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateDataCollectorData(DataCollectorData record) {
		// TODO Auto-generated method stub
		int res = dataCollectorDataDao.updateByPrimaryKeySelective(record);
		if(res > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean addDataCollectorData(DataCollectorData record) {
		// TODO Auto-generated method stub
		int res = dataCollectorDataDao.insert(record);
		if(res > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean deleteDataCollectorData(Integer collectonData_ID) {
		// TODO Auto-generated method stub
		int res = dataCollectorDataDao.deleteByPrimaryKey(collectonData_ID);
		if(res > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public List<DataCollectorData> findAllDataCollectorData() {
		// TODO Auto-generated method stub
		return dataCollectorDataDao.selectAllDataCollectorData();
	}

	@Override
	public List<DataCollectorData> findDataCollectorDataByDate(Date date) {
		// TODO Auto-generated method stub
		return dataCollectorDataDao.selectDataCollectorDataByDate(date);
	}

	@Override
	public List<DataCollectorData> findDataCollectorDataByDateBucket(Date date1, Date date2) {
		// TODO Auto-generated method stub
		return dataCollectorDataDao.selectDataCollectorDataByDateBucket(date1, date2);
	}

}
