package com.energyman.service;

import java.util.List;

import com.energyman.bean.Park;

public interface IParkService {
	/**
	 * 通过园区ID得到园区信息
	 * @param Park_ID
	 * @return
	 * @author RenYang
	 */
	public Park getParkById(Integer park_ID);
	
	/**得到所有园区
	 * @return
	 * @author RenYang
	 */
	List<Park> getAllPark();
}
