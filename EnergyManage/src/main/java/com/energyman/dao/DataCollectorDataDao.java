package com.energyman.dao;

import java.util.Date;
import java.util.List;

import com.energyman.bean.DataCollectorData;

public interface DataCollectorDataDao {
	  int deleteByPrimaryKey(Integer collectonData_ID);

	  int insert(DataCollectorData record);

	  int insertSelective(DataCollectorData record);
	  
	  DataCollectorData selectByPrimaryKey(Integer collectonData_ID);
	  
	  int updateByPrimaryKeySelective(DataCollectorData record);

	  int updateByPrimaryKey(DataCollectorData record);
	  
	  /**获得表中所有数据
	   * @return
	   * @author RenYang
	   */
	  List<DataCollectorData> selectAllDataCollectorData();
	  
	  /**按日期获得采集器数据
	   * @return
	   * @author RenYang
	   */
      List<DataCollectorData> selectDataCollectorDataByDate(Date date);
      
      /**查询某个时间段的数据
       * @param date1
       * @param date2
       * @return
       */
      List<DataCollectorData> selectDataCollectorDataByDateBucket(Date date1,Date date2);
}
