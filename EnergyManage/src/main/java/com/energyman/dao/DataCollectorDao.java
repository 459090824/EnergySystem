package com.energyman.dao;

import java.util.List;

import com.energyman.bean.DataCollector;

public interface DataCollectorDao {
	  int deleteByPrimaryKey(Integer collection_ID);

	  int insert(DataCollector record);

	  int insertSelective(DataCollector record);
	  
	  DataCollector selectByPrimaryKey(Integer collection_ID);
	  
	  int updateByPrimaryKeySelective(DataCollector record);

	  int updateByPrimaryKey(DataCollector record);
	  
	  /**查询得到所有设备
	   * @return
	   * @author RenYang
	   */
	  List<DataCollector> selectAllDataCollector();
	  
}
