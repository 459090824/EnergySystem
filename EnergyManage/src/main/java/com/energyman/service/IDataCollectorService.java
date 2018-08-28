package com.energyman.service;

import java.util.List;

import com.energyman.bean.DataCollector;

public interface IDataCollectorService {

	/**
	 * 通过collection_ID得到数据采集器信息
	 * @param  collection_ID
	 * @return
	 * @author RenYang
	 */
	public DataCollector getDataCollectorById(Integer collection_ID);
	/**
	 * 通过DataCollector对象查找数据采集器
	 * @param  DataCollector
	 * @return
	 * @author RenYang
	 */
	public DataCollector getDataCollector(DataCollector record);
	/**
	 * 通过DataCollector对象更新数据采集器信息
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean updateDataCollector(DataCollector record);
	/**
	 * 通过DataCollector对象增加数据采集器
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean addDataCollector(DataCollector record);
	/**
	 * 通过collection_ID删除数据采集器
	 * @param  collection_ID
	 * @return
	 * @author RenYang
	 */
	public boolean deleteDataCollector(Integer collection_ID);
	/**
	 * 查询得到所有数据采集器
	 * @param  
	 * @return
	 * @author RenYang
	 */
	public List<DataCollector> findAllDataCollector();
}
