package com.energyman.service;

import java.util.List;

import com.energyman.bean.WarningUnion;

public interface IWarningUnionService {

	/**
	 * 获得警告联表所有信息
	 * @return
	 * @author RenYang
	 */
	public List<WarningUnion> findAllWarningUnion();
}
