package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.BuildingUnion;
import com.energyman.dao.BuildingUnionMapper;
import com.energyman.service.IBuildingUnionService;

@Service
public class BuildingUnionService implements IBuildingUnionService{

	@Autowired
	BuildingUnionMapper buildingUnionMapper;
	
	@Override
	public List<BuildingUnion> findAllBuildingUnion() {
		// TODO Auto-generated method stub
		return buildingUnionMapper.selectBuildingUnionResult();
	}

}
