package com.energyman.dao;

import java.util.List;

import com.energyman.bean.EquipmentSubTypeUnion;

public interface EquipmentSubTypeUnionDao {
	
	/**
	 *获得子类型详细信息
	 * @param equipmentSubType_state
	 */
	List<EquipmentSubTypeUnion> selectEquipmentSubTypeUnionResult(Integer equipmentSubType_state);
}
