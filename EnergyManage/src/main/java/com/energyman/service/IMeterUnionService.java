package com.energyman.service;

import java.util.List;

import com.energyman.bean.MeterUnion;

public interface IMeterUnionService {
	
	/**
	 * 获得仪器联表所有信息(删除的除外)
	 * @return
	 * @author RenYang
	 */
	public List<MeterUnion> findAllMeterUnion(Integer state_ID);
}
