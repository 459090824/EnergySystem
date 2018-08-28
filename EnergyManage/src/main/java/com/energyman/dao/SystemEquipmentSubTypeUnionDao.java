package com.energyman.dao;

import java.util.List;

import com.energyman.bean.SystemEquipmentSubTypeUnion;

public interface SystemEquipmentSubTypeUnionDao {
	
	/**
	 * 获得设备子类型详细信息（除删除类型除外）
	 * @param systemEquipmentSubType_ID
	 * @return
	 */
	List<SystemEquipmentSubTypeUnion> selectSystemEquipmentSubTypeUnionResult(Integer systemEquipmentSubState_ID);
}	
