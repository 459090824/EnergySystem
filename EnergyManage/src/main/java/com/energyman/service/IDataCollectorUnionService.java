package com.energyman.service;

import java.util.List;

import com.energyman.bean.DataCollectorUnion;

public interface IDataCollectorUnionService {
	/**
	 * 获得数据采集器联表所有信息(删除的除外)
	 * @return
	 * @author RenYang
	 */
	public List<DataCollectorUnion> findAllDataCollectorUnion(Integer state_ID);
}
