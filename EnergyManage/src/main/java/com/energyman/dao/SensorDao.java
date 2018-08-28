package com.energyman.dao;

import com.energyman.bean.Sensor;

public interface SensorDao {
	int deleteByPrimaryKey(Integer sensor_ID);

    int insert(Sensor record);

    int insertSelective(Sensor record);

    Sensor selectByPrimaryKey(Integer sensor_ID);

    int updateByPrimaryKeySelective(Sensor record);

    int updateByPrimaryKey(Sensor record);
}
