package com.energyman.service;

import java.util.List;

import com.energyman.bean.MeterType;

public interface IMeterTypeService {
	/**
	 * 通过仪表类型ID得到类型信息
	 * @param meterType_ID
	 * @return
	 * @author RenYang
	 */
	public MeterType getMeterTypeById(Integer meterType_ID);
	/**
	 * 通过MeterType对象增加仪表类型
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean addMeterType(MeterType record);
	/**
	 * 通过MeterType对象更新类型信息
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean updateMeterType(MeterType record);
	/**
	 * 通过meterType_ID删除类型信息
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean deleteMeterType(Integer meterType_ID);
	/**
	 * 通过展示查看所有类型
	 * @return
	 * @author RenYang
	 */
	public List<MeterType> findAllMeterType();
}
