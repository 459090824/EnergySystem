package com.energyman.service;

import com.energyman.bean.Sensor;

public interface ISensorService {
	/**
	 * 通过sensor_ID得到传感器信息
	 * @param  sensor_ID
	 * @return
	 * @author RenYang
	 */
	public Sensor getSensorById(Integer sensor_ID);
	/**
	 * 通过Sensor对象查找传感器
	 * @param  Sensor
	 * @return
	 * @author RenYang
	 */
	public Sensor getEquipment(Sensor record);
	/**
	 * 通过Sensor对象更新传感器信息
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean updateSensor(Sensor record);
	/**
	 * 通过Sensor对象增加传感器
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean addSensor(Sensor record);
	/**
	 * 通过sensor_ID删除传感器
	 * @param  sensor_ID
	 * @return
	 * @author RenYang
	 */
	public boolean deleteSensor(Integer sensor_ID);
}
