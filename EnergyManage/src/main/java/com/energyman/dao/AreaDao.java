package com.energyman.dao;

import java.util.List;

import com.energyman.bean.Area;

public interface AreaDao {
	  int deleteByPrimaryKey(Integer region_ID);

	  int insert(Area record);

	  int insertSelective(Area record);
	  
	  Area selectByPrimaryKey(Integer region_ID);
	  
	  int updateByPrimaryKeySelective(Area record);

	  int updateByPrimaryKey(Area record);
	  
	  /**
	   * 获得所有area信息
	   * @return
	   */
	  List<Area> selectAllArea();
	  
	  /**
	   * 通过园区查所对应的区域
	   * @param park_ID
	   * @return
	   */
	  List<Area> selectByPark(Integer park_ID);
}
