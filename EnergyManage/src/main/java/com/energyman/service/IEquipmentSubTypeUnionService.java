package com.energyman.service;

import java.util.List;

import com.energyman.bean.EquipmentSubTypeUnion;

public interface IEquipmentSubTypeUnionService {
	
	/**
	 *获得子类型详细信息
	 * @param equipmentSubType_state
	 */
	List<EquipmentSubTypeUnion> findEquipmentSubTypeUnionResult(Integer equipmentSubType_state);
}	
