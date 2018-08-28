package com.energyman.service;

import java.util.List;

import com.energyman.bean.DataCollectorType;

public interface IDataCollectorTypeService {

	/**
	 * 通过数据采集器类型ID得到类型信息
	 * @param collectionType_ID
	 * @return
	 * @author RenYang
	 */
	public DataCollectorType getDataCollectorTypeById(Integer collectionType_ID);
	/**
	 * 通过DataCollectorType对象增加采集器类型
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean addDataCollectorType(DataCollectorType record);
	/**
	 * 通过MeterType对象更新类型信息
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean updateDataCollectorType(DataCollectorType record);
	/**
	 * 通过collectionType_ID删除类型信息
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean deleteDataCollectorType(Integer collectionType_ID);
	/**
	 * 通过展示查看所有类型
	 * @return
	 * @author RenYang
	 */
	public List<DataCollectorType> findAllDataCollectorType();
}
