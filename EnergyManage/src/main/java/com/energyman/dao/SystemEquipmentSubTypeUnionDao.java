package com.energyman.dao;

import java.util.List;

import com.energyman.bean.SystemEquipmentSubTypeUnion;

public interface SystemEquipmentSubTypeUnionDao {
	
	/**
	 * ����豸��������ϸ��Ϣ����ɾ�����ͳ��⣩
	 * @param systemEquipmentSubType_ID
	 * @return
	 */
	List<SystemEquipmentSubTypeUnion> selectSystemEquipmentSubTypeUnionResult(Integer systemEquipmentSubState_ID);
}	
