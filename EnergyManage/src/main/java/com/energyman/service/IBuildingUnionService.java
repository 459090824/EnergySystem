package com.energyman.service;

import java.util.List;

import com.energyman.bean.BuildingUnion;

public interface IBuildingUnionService {

	/**
	 * 获得建筑联表所有信息
	 * @return
	 * @author RenYang
	 */
	public List<BuildingUnion> findAllBuildingUnion();
}
