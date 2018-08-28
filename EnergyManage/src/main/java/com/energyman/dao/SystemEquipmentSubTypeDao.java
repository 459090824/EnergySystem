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
	  
	  /**��ѯ��������������Ϣ
	   * @return
	   * @author RenYang
	   */
	  List<SystemEquipmentSubType> selectAllSystemEquipmentSubType(Integer systemEquipmentSubState_ID);
	  
	  
	  /**
	   * ͨ���豸���ͻ��������Ӧ��δɾ�����豸������
	   * @param systemEquipmentType_ID
	   * @return
	   */
	  List<SystemEquipmentSubType> selectSystemEquipmentSubTypeBySystemEquipmentType(Integer systemEquipmentType_ID, Integer systemEquipmentSubState_ID);
}
