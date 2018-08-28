package com.energyman.dao;

import java.util.List;

import com.energyman.bean.DataCollectorType;

public interface DataCollectorTypeDao {
	  int deleteByPrimaryKey(Integer collectionType_ID);

	  int insert(DataCollectorType record);

	  int insertSelective(DataCollectorType record);
	  
	  DataCollectorType selectByPrimaryKey(Integer collectionType_ID);
	  
	  int updateByPrimaryKeySelective(DataCollectorType record);

	  int updateByPrimaryKey(DataCollectorType record);
	  
	  /**查询到所有类型信息
	   * @return
	   * @author RenYang
	   */
	  List<DataCollectorType> selectAllDataCollectorType();
}
