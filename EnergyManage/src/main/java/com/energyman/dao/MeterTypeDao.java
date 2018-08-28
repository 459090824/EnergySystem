package com.energyman.dao;

import java.util.List;

import com.energyman.bean.MeterType;

public interface MeterTypeDao {
	  int deleteByPrimaryKey(Integer meterType_ID);

	  int insert(MeterType record);

	  int insertSelective(MeterType record);
	  
	  MeterType selectByPrimaryKey(Integer meterType_ID);
	  
	  int updateByPrimaryKeySelective(MeterType record);

	  int updateByPrimaryKey(MeterType record);
	  
	  /**��ѯ������������Ϣ
	   * @return
	   * @author RenYang
	   */
	  List<MeterType> selectAllMeterType();
}
