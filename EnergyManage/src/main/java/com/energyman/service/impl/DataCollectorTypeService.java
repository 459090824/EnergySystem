package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.DataCollectorType;
import com.energyman.dao.DataCollectorTypeDao;
import com.energyman.service.IDataCollectorTypeService;

@Service
public class DataCollectorTypeService implements IDataCollectorTypeService {

	@Autowired
	DataCollectorTypeDao dataCollectorTypeDao;
	
	@Override
	public DataCollectorType getDataCollectorTypeById(Integer collectionType_ID) {
		// TODO Auto-generated method stub
		return dataCollectorTypeDao.selectByPrimaryKey(collectionType_ID);
	}

	@Override
	public boolean addDataCollectorType(DataCollectorType record) {
		// TODO Auto-generated method stub
		int result=dataCollectorTypeDao.insert(record);
		if(result > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean updateDataCollectorType(DataCollectorType record) {
		// TODO Auto-generated method stub
		int result=dataCollectorTypeDao.updateByPrimaryKeySelective(record);
		if(result > 0){
			return true;
		}else{
			return false;
		}	
	}

	@Override
	public boolean deleteDataCollectorType(Integer collectionType_ID) {
		// TODO Auto-generated method stub
		int result=dataCollectorTypeDao.deleteByPrimaryKey(collectionType_ID);
		if(result > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public List<DataCollectorType> findAllDataCollectorType() {
		// TODO Auto-generated method stub
		return dataCollectorTypeDao.selectAllDataCollectorType();
	}

}
