package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.Area;
import com.energyman.dao.AreaDao;
import com.energyman.service.IAreaService;

@Service
public class AreaService implements IAreaService{
	
	@Autowired
	AreaDao areaDao;

	@Override
	public Area getAreaById(Integer region_ID) {
		// TODO Auto-generated method stub
		return areaDao.selectByPrimaryKey(region_ID);
	}

	@Override
	public boolean addArea(Area record) {
		// TODO Auto-generated method stub
		int result=areaDao.insert(record);
		if(result > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean updateArea(Area record) {
		// TODO Auto-generated method stub
		int result=areaDao.updateByPrimaryKeySelective(record);
		if(result > 0){
			return true;
		}else {
			return false;
		}		
	}

	@Override
	public boolean deleteArea(Integer region_ID) {
		// TODO Auto-generated method stub
		int result=areaDao.deleteByPrimaryKey(region_ID);
		if(result > 0){
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<Area> findAllArea() {
		// TODO Auto-generated method stub
		List<Area> areas=areaDao.selectAllArea();
		return areas;
	}

	@Override
	public List<Area> getAreaByPark(Integer park_ID) {
		// TODO Auto-generated method stub
		return areaDao.selectByPark(park_ID);
	}
	
}
