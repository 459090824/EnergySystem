package com.energyman.dao;

import java.util.List;

import com.energyman.bean.SystemEquipmentSubType;

public interface SystemEquipmentSubTypeDao {
	
	  int deleteByPrimaryKey(Integer systemEquipmentSubType_ID);

	  int insert(SystemEquipmentSubType record);

	  int insertSelective(SystemEquipmentSubType record);
	  
	  SystemEquipmentSubType selectByPrimaryKey(Integer systemEquipmentSubType_ID);
	  
	  int updateByPrimaryKeySelective(SystemEquipmentSubType record);

	  int updateByPrimaryKey(SystemEquipmentSubType record);
	  
	  /**查询到所有子类型信息
	   * @return
	   * @author RenYang
	   */
	  List<SystemEquipmentSubType> selectAllSystemEquipmentSubType(Integer systemEquipmentSubState_ID);
	  
	  
	  /**
	   * 通过设备类型获得其所对应的未删除的设备子类型
	   * @param systemEquipmentType_ID
	   * @return
	   */
	  List<SystemEquipmentSubType> selectSystemEquipmentSubTypeBySystemEquipmentType(Integer systemEquipmentType_ID, Integer systemEquipmentSubState_ID);
}
