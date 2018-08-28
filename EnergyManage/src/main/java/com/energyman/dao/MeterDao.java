package com.energyman.dao;

import java.util.List;

import com.energyman.bean.Meter;

public interface MeterDao {
	  int deleteByPrimaryKey(Integer meter_ID);

	  int insert(Meter record);

	  int insertSelective(Meter record);
	  
	  Meter selectByPrimaryKey(Integer meter_ID);
	  
	  int updateByPrimaryKeySelective(Meter record);

	  int updateByPrimaryKey(Meter record);
	  
	  /**查询得到所有仪器
	   * @return
	   * @author RenYang
	   */
	  List<Meter> selectAllMeter();
}
