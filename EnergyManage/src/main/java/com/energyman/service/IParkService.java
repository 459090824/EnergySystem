package com.energyman.service;

import java.util.List;

import com.energyman.bean.Park;

public interface IParkService {
	/**
	 * ͨ��԰��ID�õ�԰����Ϣ
	 * @param Park_ID
	 * @return
	 * @author RenYang
	 */
	public Park getParkById(Integer park_ID);
	
	/**�õ�����԰��
	 * @return
	 * @author RenYang
	 */
	List<Park> getAllPark();
}
