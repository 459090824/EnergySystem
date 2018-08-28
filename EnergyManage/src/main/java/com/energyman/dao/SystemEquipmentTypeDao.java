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
	  
	  /**��ѯ������������Ϣ
	   * @return
	   * @author RenYang
	   */
	  List<SystemEquipmentType> selectAllSystemEquipmentType(Integer systemEquipmentState_ID);
}
