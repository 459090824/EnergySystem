package com.energyman.dao;

import java.util.List;

import com.energyman.bean.EquipmentDispatchUnion;

public interface EquipmentDispatchUnionMapper {

	/**
	 * 正常调度设备信息
	 * @return
	 */
	List<EquipmentDispatchUnion> selectEquipmentDispatchUnionResult();
}
