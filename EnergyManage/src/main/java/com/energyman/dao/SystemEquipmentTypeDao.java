package com.energyman.dao;

import java.util.List;

import com.energyman.bean.SystemEquipmentType;

public interface SystemEquipmentTypeDao {
	
	  int deleteByPrimaryKey(Integer systemEquipmentType_ID);

	  int insert(SystemEquipmentType record);

	  int insertSelective(SystemEquipmentType record);
	  
	  SystemEquipmentType selectByPrimaryKey(Integer systemEquipmentType_ID);
	  
	  int updateByPrimaryKeySelective(SystemEquipmentType record);

	  int updateByPrimaryKey(SystemEquipmentType record);
	  
	  /**查询到所有类型信息
	   * @return
	   * @author RenYang
	   */
	  List<SystemEquipmentType> selectAllSystemEquipmentType(Integer systemEquipmentState_ID);
}
