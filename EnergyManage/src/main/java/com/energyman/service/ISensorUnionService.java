package com.energyman.service;

import java.util.List;

import com.energyman.bean.SensorUnion;

public interface ISensorUnionService {

	/**
	 * 获得传感器联表所有信息
	 * @return
	 * @author RenYang
	 */
	public List<SensorUnion> findAllSensorUnion(Integer state_ID);
}
