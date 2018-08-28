package com.energyman.service;

import java.util.List;

import com.energyman.bean.EquipmentDispatchUnion;

public interface IEquipmentDispatchUnionService {

	/**
	 * 正常调度设备信息
	 * @return
	 */
	public List<EquipmentDispatchUnion> findEquipmentDispatchUnionResult();
}
