package com.energyman.service;

import java.util.List;

import com.energyman.bean.EquipmentSubTypeUnion;

public interface IEquipmentSubTypeUnionService {
	
	/**
	 *�����������ϸ��Ϣ
	 * @param equipmentSubType_state
	 */
	List<EquipmentSubTypeUnion> findEquipmentSubTypeUnionResult(Integer equipmentSubType_state);
}	
