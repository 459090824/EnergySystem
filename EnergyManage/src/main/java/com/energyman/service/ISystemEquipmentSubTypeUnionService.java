package com.energyman.service;

import java.util.List;

import com.energyman.bean.SystemEquipmentSubTypeUnion;

public interface ISystemEquipmentSubTypeUnionService {

	/**
	 * ����豸��������ϸ��Ϣ����ɾ�����ͳ��⣩
	 * @param systemEquipmentSubType_ID
	 * @return
	 */
	List<SystemEquipmentSubTypeUnion> findSystemEquipmentSubTypeUnionResult(Integer systemEquipmentSubState_ID);
}
