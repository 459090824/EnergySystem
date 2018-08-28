package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.Building;
import com.energyman.dao.BuildingDao;
import com.energyman.service.IBuildingService;

@Service
public class BuildingService implements IBuildingService {

	@Autowired
	BuildingDao buildingDao;
	
	@Override
	public Building getBuildingById(Integer build_ID) {
		// TODO Auto-generated method stub
		return buildingDao.selectByPrimaryKey(build_ID);
	}

	@Override
	public List<Building> findAllBuilding() {
		// TODO Auto-generated method stub
		List<Building> buildings=buildingDao.selectAllBuilidng();
		return buildings;
	}

	@Override
	public List<Building> getBuildingByArea(Integer region_ID) {
		// TODO Auto-generated method stub
		return buildingDao.selectByArea(region_ID);
	}

	@Override
	public boolean updateBuilding(Building record) {
		// TODO Auto-generated method stub
		int res=buildingDao.updateByPrimaryKeySelective(record);
		if(res > 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean addBuilding(Building record) {
		// TODO Auto-generated method stub
		int res=buildingDao.insert(record);
		if(res > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean deleteBuilding(Integer build_ID) {
		// TODO Auto-generated method stub
		int res=buildingDao.deleteByPrimaryKey(build_ID);
		if(res > 0){
			return true;
		}else {
			return false;
		}		
	}

}
