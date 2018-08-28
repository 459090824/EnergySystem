package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.Park;
import com.energyman.dao.ParkDao;
import com.energyman.service.IParkService;

@Service
public class ParkService implements IParkService{

	@Autowired
	ParkDao parkDao;
	
	@Override
	public Park getParkById(Integer park_ID) {
		// TODO Auto-generated method stub
		return parkDao.selectByPrimaryKey(park_ID);
	}

	@Override
	public List<Park> getAllPark() {
		// TODO Auto-generated method stub
		List<Park> parks=parkDao.selectAllPark();
		return parks;
	}

}
