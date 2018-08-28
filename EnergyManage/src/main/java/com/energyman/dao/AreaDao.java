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
	   * �������area��Ϣ
	   * @return
	   */
	  List<Area> selectAllArea();
	  
	  /**
	   * ͨ��԰��������Ӧ������
	   * @param park_ID
	   * @return
	   */
	  List<Area> selectByPark(Integer park_ID);
}
