package com.energyman.service;

import java.util.List;

import com.energyman.bean.DataCollectorUnion;

public interface IDataCollectorUnionService {
	/**
	 * ������ݲɼ�������������Ϣ(ɾ���ĳ���)
	 * @return
	 * @author RenYang
	 */
	public List<DataCollectorUnion> findAllDataCollectorUnion(Integer state_ID);
}
