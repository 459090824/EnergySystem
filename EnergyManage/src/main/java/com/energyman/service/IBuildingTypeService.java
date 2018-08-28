package com.energyman.service;

import java.util.List;

import com.energyman.bean.BuildingType;

public interface IBuildingTypeService {
	
	/**
	 * 通过buildType_ID得到建筑类型信息
	 * @param  buildType_ID
	 * @return
	 * @author RenYang
	 */
	public BuildingType getBuildingTypeById(Integer buildType_ID);
	/**
	 * 通过BuildingType对象更新建筑类型信息
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean updateBuildingType(BuildingType record);
	/**
	 * 通过BuildingType对象增加建筑类型
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean addBuildingType(BuildingType record);
	/**
	 * 通过buildType_ID删除建筑类型
	 * @param  buildType_ID
	 * @return
	 * @author RenYang
	 */
	public boolean deleteBuildingType(Integer buildType_ID);
	/**
	 * 查询得到所有建筑类型信息
	 * @param  
	 * @return
	 * @author RenYang
	 */
	public List<BuildingType> findAllBuildingType();
}
