package com.energyman.service;

import java.util.List;

import com.energyman.bean.SensorType;

public interface ISensorTypeService {
	/**
	 * ͨ������������ID�õ�������Ϣ
	 * @param meterType_ID
	 * @return
	 * @author RenYang
	 */
	public SensorType getSensorTypeById(Integer sensorType_ID);
	/**
	 * ͨ��SensorType�������Ӵ���������
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean addSensorType(SensorType record);
	/**
	 * ͨ��SensorType�������������Ϣ
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean updateSensorType(SensorType record);
	/**
	 * ͨ��sensorType_IDɾ��������Ϣ
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean deleteSensorType(Integer sensorType_ID);
	/**
	 * ͨ��չʾ�鿴��������
	 * @return
	 * @author RenYang
	 */
	public List<SensorType> findAllSensorType();
}
