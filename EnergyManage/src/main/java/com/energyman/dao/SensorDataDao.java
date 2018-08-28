package com.energyman.dao;

import com.energyman.bean.SensorData;

public interface SensorDataDao {
	int deleteByPrimaryKey(Integer sensorData_ID);

    int insert(SensorData record);

    int insertSelective(SensorData record);

    SensorData selectByPrimaryKey(Integer sensorData_ID);

    int updateByPrimaryKeySelective(SensorData record);

    int updateByPrimaryKey(SensorData record);
}
