package com.energyman.dao;

import java.util.List;

import com.energyman.bean.EquipmentDispatch;

public interface EquipmentDispatchDao {
	 int deleteByPrimaryKey(Integer dispatch_ID);

	  int insert(EquipmentDispatch record);

	  int insertSelective(EquipmentDispatch record);
	  
	  EquipmentDispatch selectByPrimaryKey(Integer dispatch_ID);
	  
	  int updateByPrimaryKeySelective(EquipmentDispatch record);

	  int updateByPrimaryKey(EquipmentDispatch record);
	  
	  /**查询处于调度状态的设备
	   * @return
	   */
	  List<EquipmentDispatch> selectAllEquipmentDispatch();
}
