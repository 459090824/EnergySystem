package com.energyman.dao;

import java.util.List;

import com.energyman.bean.EquipmentSubTypeUnion;

public interface EquipmentSubTypeUnionDao {
	
	/**
	 *�����������ϸ��Ϣ
	 * @param equipmentSubType_state
	 */
	List<EquipmentSubTypeUnion> selectEquipmentSubTypeUnionResult(Integer equipmentSubType_state);
}
