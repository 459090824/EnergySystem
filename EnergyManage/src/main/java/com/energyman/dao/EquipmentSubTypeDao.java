package com.energyman.dao;

import java.util.List;

import com.energyman.bean.EquipmentSubType;

public interface EquipmentSubTypeDao {
	  int deleteByPrimaryKey(Integer equipmentSubType_ID);

	  int insert(EquipmentSubType record);

	  int insertSelective(EquipmentSubType record);
	  
	  EquipmentSubType selectByPrimaryKey(Integer equipmentSubType_ID);
	  
	  int updateByPrimaryKeySelective(EquipmentSubType record);

	  int updateByPrimaryKey(EquipmentSubType record);
	  
	  /**获得所有设备子类型(删除的除外)
	   * @return
	   * @author RenYang
	   */
	  List<EquipmentSubType> selectAllEquipmentSubType(Integer equipmentSubType_state);
	  
	  
	  /**
	   * 查询设备类型所属未删除的设备子类型
	   * @param equipmentType_ID
	   * @return
	   */
	  List<EquipmentSubType> selectEquipmentSubTypeByEquipmentType(Integer equipmentType_ID,Integer equipmentSubType_state);
}
