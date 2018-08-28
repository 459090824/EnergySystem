package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.BuildingType;
import com.energyman.dao.BuildingTypeDao;
import com.energyman.service.IBuildingTypeService;

@Service
public class BuildingTypeService implements IBuildingTypeService {

	@Autowired
	BuildingTypeDao buildingTypeDao;
	
	@Override
	public BuildingType getBuildingTypeById(Integer buildType_ID) {
		// TODO Auto-generated method stub
		return buildingTypeDao.selectByPrimaryKey(buildType_ID);
	}

	@Override
	public boolean updateBuildingType(BuildingType record) {
		// TODO Auto-generated method stub
		int res=buildingTypeDao.updateByPrimaryKeySelective(record);
		if(res > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean addBuildingType(BuildingType record) {
		// TODO Auto-generated method stub
		int res=buildingTypeDao.insert(record);
		if(res > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean deleteBuildingType(Integer buildType_ID) {
		// TODO Auto-generated method stub
		int res=buildingTypeDao.deleteByPrimaryKey(buildType_ID);
		if(res > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public List<BuildingType> findAllBuildingType() {
		// TODO Auto-generated method stub
		return buildingTypeDao.selectAllBuildingType();
	}

}
