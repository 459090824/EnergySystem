package com.energyman.dao;

import java.util.List;

import com.energyman.bean.OtherSystemEquipmentUnion;

public interface OtherSystemEquipmentUnionDao {
	
	/**
	 * 联合查找其它系统设备详细信息(删除设备除外)
	 * @return
	 */
	List<OtherSystemEquipmentUnion> selectOtherSystemEquipmentUnionResult(Integer stateID);
}
