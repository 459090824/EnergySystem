package com.energyman.service;

import java.util.List;

import com.energyman.bean.SuddenDispatchUnion;

public interface ISuddenDispatchUnionService {
	
	/**
	 * 正常调度设备信息
	 * @return
	 */
	public List<SuddenDispatchUnion> findSuddenDispatchUnionResult();
}
