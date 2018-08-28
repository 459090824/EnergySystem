package com.energyman.service;

import java.util.List;

import com.energyman.bean.Building;

public interface IBuildingService {
	
	/**
	 * 通过build_ID得到建筑信息
	 * @param  build_ID
	 * @return
	 * @author RenYang
	 */
	public Building getBuildingById(Integer build_ID);
	/**
	 * 通过Building对象更新建筑信息
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean updateBuilding(Building record);
	/**
	 * 通过Building对象增加建筑
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean addBuilding(Building record);
	/**
	 * 通过build_ID删除建筑
	 * @param  build_ID
	 * @return
	 * @author RenYang
	 */
	public boolean deleteBuilding(Integer build_ID);
	/**
	 * 查询得到所有建筑信息
	 * @param  
	 * @return
	 * @author RenYang
	 */
	public List<Building> findAllBuilding();
	
	/**获得相对应园区的区域
	 * @param region_ID
	 * @return
	 * @author RenYang
	 */
	public List<Building> getBuildingByArea(Integer region_ID);
}
