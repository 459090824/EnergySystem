package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.MeterType;
import com.energyman.dao.MeterTypeDao;
import com.energyman.service.IMeterTypeService;

@Service
public class MeterTypeService implements IMeterTypeService {
	
	@Autowired
	MeterTypeDao meterTypeDao;
	
	@Override
	public MeterType getMeterTypeById(Integer meterType_ID) {
		// TODO Auto-generated method stub
		return meterTypeDao.selectByPrimaryKey(meterType_ID);
	}

	@Override
	public boolean addMeterType(MeterType record) {
		// TODO Auto-generated method stub
		int result=meterTypeDao.insert(record);
		if(result > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean updateMeterType(MeterType record) {
		// TODO Auto-generated method stub
		int result=meterTypeDao.updateByPrimaryKeySelective(record);
		if(result > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean deleteMeterType(Integer meterType_ID) {
		// TODO Auto-generated method stub
		int result=meterTypeDao.deleteByPrimaryKey(meterType_ID);
		if(result > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public List<MeterType> findAllMeterType() {
		// TODO Auto-generated method stub
		return meterTypeDao.selectAllMeterType();
	}

}
