package com.energyman.dao;

import java.util.List;

import com.energyman.bean.SuddenDispatchUnion;

public interface SuddenDispatchUnionMapper {
	
	/**
	 * 突发调度设备信息
	 * @return
	 */
	List<SuddenDispatchUnion> selectSuddenDispatchUnionResult();
}
