package com.energyman.dao;

import java.util.List;

import com.energyman.bean.OtherSystemEquipmentUnion;

public interface OtherSystemEquipmentUnionDao {
	
	/**
	 * ���ϲ�������ϵͳ�豸��ϸ��Ϣ(ɾ���豸����)
	 * @return
	 */
	List<OtherSystemEquipmentUnion> selectOtherSystemEquipmentUnionResult(Integer stateID);
}
