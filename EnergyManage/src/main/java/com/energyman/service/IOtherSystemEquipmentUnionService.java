package com.energyman.service;

import java.util.List;

import com.energyman.bean.OtherSystemEquipmentUnion;

public interface IOtherSystemEquipmentUnionService {
	
	/**
	 * ���ϲ�������ϵͳ�豸��ϸ��Ϣ(ɾ���豸����)
	 * @return
	 */
	List<OtherSystemEquipmentUnion> findOtherSystemEquipmentUnionResult(Integer stateID);
}
