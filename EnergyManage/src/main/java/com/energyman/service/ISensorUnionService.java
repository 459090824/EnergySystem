package com.energyman.service;

import java.util.List;

import com.energyman.bean.SensorUnion;

public interface ISensorUnionService {

	/**
	 * ��ô���������������Ϣ
	 * @return
	 * @author RenYang
	 */
	public List<SensorUnion> findAllSensorUnion(Integer state_ID);
}
