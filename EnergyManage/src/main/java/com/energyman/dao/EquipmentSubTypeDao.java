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
	  
	  /**��������豸������(ɾ���ĳ���)
	   * @return
	   * @author RenYang
	   */
	  List<EquipmentSubType> selectAllEquipmentSubType(Integer equipmentSubType_state);
	  
	  
	  /**
	   * ��ѯ�豸��������δɾ�����豸������
	   * @param equipmentType_ID
	   * @return
	   */
	  List<EquipmentSubType> selectEquipmentSubTypeByEquipmentType(Integer equipmentType_ID,Integer equipmentSubType_state);
}
