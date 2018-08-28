package com.energyman.dao;

import java.util.List;

import com.energyman.bean.EquipmentType;

public interface EquipmentTypeDao {
	  int deleteByPrimaryKey(Integer equipmentType_ID);

	  int insert(EquipmentType record);

	  int insertSelective(EquipmentType record);
	  
	  EquipmentType selectByPrimaryKey(Integer equipmentType_ID);
	  
	  int updateByPrimaryKeySelective(EquipmentType record);

	  int updateByPrimaryKey(EquipmentType record);
	  
	  /**获得所有设备父类型(删除的除外)
	   * @return
	   * @author RenYang
	   */
	  List<EquipmentType> selectAllEquipmentType(Integer equipmentType_state);
	  
}
