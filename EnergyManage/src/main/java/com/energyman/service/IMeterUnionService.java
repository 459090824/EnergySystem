package com.energyman.service;

import java.util.List;

import com.energyman.bean.MeterUnion;

public interface IMeterUnionService {
	
	/**
	 * �����������������Ϣ(ɾ���ĳ���)
	 * @return
	 * @author RenYang
	 */
	public List<MeterUnion> findAllMeterUnion(Integer state_ID);
}
