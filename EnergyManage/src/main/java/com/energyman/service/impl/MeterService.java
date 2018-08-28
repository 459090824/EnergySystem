package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.Meter;
import com.energyman.dao.MeterDao;
import com.energyman.service.IMeterService;

@Service
public class MeterService implements IMeterService {

	@Autowired
	MeterDao meterDao;
	
	@Override
	public Meter getMeterById(Integer meter_ID) {
		// TODO Auto-generated method stub
		return meterDao.selectByPrimaryKey(meter_ID);
	}

	@Override
	public Meter getMeter(Meter record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateMeter(Meter record) {
		// TODO Auto-generated method stub
		int res=meterDao.updateByPrimaryKeySelective(record);
		if(res > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean addMeter(Meter record) {
		// TODO Auto-generated method stub
		int res=meterDao.insert(record);
		if(res > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean deleteMeter(Integer meter_ID) {
		// TODO Auto-generated method stub
		int res=meterDao.deleteByPrimaryKey(meter_ID);
		if(res > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public List<Meter> findAllMeter() {
		// TODO Auto-generated method stub
		return meterDao.selectAllMeter();
	}

}
