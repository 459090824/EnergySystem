package com.energyman.dao;

import java.util.List;

import com.energyman.bean.SensorType;

public interface SensorTypeDao {
	int deleteByPrimaryKey(Integer sensorType_ID);

    int insert(SensorType record);

    int insertSelective(SensorType record);

    SensorType selectByPrimaryKey(Integer sensorType_ID);

    int updateByPrimaryKeySelective(SensorType record);

    int updateByPrimaryKey(SensorType record);
    
    /**��ѯ������������Ϣ
	   * @return
	   * @author RenYang
	   */
	List<SensorType> selectAllSensorType();
}
