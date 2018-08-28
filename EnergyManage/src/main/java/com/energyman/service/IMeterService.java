package com.energyman.service;

import java.util.List;

import com.energyman.bean.Meter;

public interface IMeterService {

	/**
	 * 通过meter_ID得到仪器信息
	 * @param  meter_ID
	 * @return
	 * @author RenYang
	 */
	public Meter getMeterById(Integer meter_ID);
	/**
	 * 通过Meter对象查找仪器
	 * @param  Meter
	 * @return
	 * @author RenYang
	 */
	public Meter getMeter(Meter record);
	/**
	 * 通过Meter对象更新仪器信息
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean updateMeter(Meter record);
	/**
	 * 通过Meter对象增加仪器
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean addMeter(Meter record);
	/**
	 * 通过meter_ID删除仪器
	 * @param  meter_ID
	 * @return
	 * @author RenYang
	 */
	public boolean deleteMeter(Integer meter_ID);
	/**
	 * 查询得到所有仪器
	 * @param  
	 * @return
	 * @author RenYang
	 */
	public List<Meter> findAllMeter();
}
