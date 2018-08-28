package com.energyman.service;

import java.util.List;

import com.energyman.bean.OtherSystemEquipmentUnion;

public interface IOtherSystemEquipmentUnionService {
	
	/**
	 * 联合查找其它系统设备详细信息(删除设备除外)
	 * @return
	 */
	List<OtherSystemEquipmentUnion> findOtherSystemEquipmentUnionResult(Integer stateID);
}
