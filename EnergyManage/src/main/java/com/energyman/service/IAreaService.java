package com.energyman.service;

import java.util.List;

import com.energyman.bean.Area;

public interface IAreaService {
	/**
	 * 通过区域ID得到区域信息
	 * @param Region_ID
	 * @return
	 * @author RenYang
	 */
	public Area getAreaById(Integer region_ID);
	/**
	 * 通过Area对象增加区域
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean addArea(Area record);
	/**
	 * 通过Area对象更新区域信息
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean updateArea(Area record);
	/**
	 * 通过Region_ID删除区域
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean deleteArea(Integer region_ID);
	/**
	 * 通过展示查看区域信息
	 * @return
	 * @author RenYang
	 */
	public List<Area> findAllArea();
	/**获得相对应园区的区域
	 * @param park_ID
	 * @return
	 * @author RenYang
	 */
	public List<Area> getAreaByPark(Integer park_ID);
}
