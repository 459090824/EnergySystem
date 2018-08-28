package com.energyman.service;

import com.energyman.bean.Sensor;

public interface ISensorService {
	/**
	 * ͨ��sensor_ID�õ���������Ϣ
	 * @param  sensor_ID
	 * @return
	 * @author RenYang
	 */
	public Sensor getSensorById(Integer sensor_ID);
	/**
	 * ͨ��Sensor������Ҵ�����
	 * @param  Sensor
	 * @return
	 * @author RenYang
	 */
	public Sensor getEquipment(Sensor record);
	/**
	 * ͨ��Sensor������´�������Ϣ
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean updateSensor(Sensor record);
	/**
	 * ͨ��Sensor�������Ӵ�����
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean addSensor(Sensor record);
	/**
	 * ͨ��sensor_IDɾ��������
	 * @param  sensor_ID
	 * @return
	 * @author RenYang
	 */
	public boolean deleteSensor(Integer sensor_ID);
}
