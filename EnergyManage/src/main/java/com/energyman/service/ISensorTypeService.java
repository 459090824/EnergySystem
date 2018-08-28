package com.energyman.service;

import java.util.List;

import com.energyman.bean.SensorType;

public interface ISensorTypeService {
	/**
	 * 通过传感器类型ID得到类型信息
	 * @param meterType_ID
	 * @return
	 * @author RenYang
	 */
	public SensorType getSensorTypeById(Integer sensorType_ID);
	/**
	 * 通过SensorType对象增加传感器类型
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean addSensorType(SensorType record);
	/**
	 * 通过SensorType对象更新类型信息
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean updateSensorType(SensorType record);
	/**
	 * 通过sensorType_ID删除类型信息
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean deleteSensorType(Integer sensorType_ID);
	/**
	 * 通过展示查看所有类型
	 * @return
	 * @author RenYang
	 */
	public List<SensorType> findAllSensorType();
}
