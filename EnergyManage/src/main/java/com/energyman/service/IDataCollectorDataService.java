package com.energyman.service;

import java.util.Date;
import java.util.List;

import com.energyman.bean.DataCollectorData;

public interface IDataCollectorDataService {
	/**
	 * 通过collectonData_ID得到数据采集器数据
	 * @param  collectonData_ID
	 * @return
	 * @author RenYang
	 */
	public DataCollectorData getDataCollectorDataById(Integer collectonData_ID);
	/**
	 * 通过DataCollectorData对象查找数据采集器数据
	 * @param  DataCollectorData
	 * @return
	 * @author RenYang
	 */
	public DataCollectorData getDataCollectorData(DataCollectorData record);
	/**
	 * 通过DataCollectorData对象更新数据采集器数据
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean updateDataCollectorData(DataCollectorData record);
	/**
	 * 通过DataCollectorData对象增加数据采集器数据
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean addDataCollectorData(DataCollectorData record);
	/**
	 * 通过collectonData_ID删除数据采集器数据
	 * @param  collectonData_ID
	 * @return
	 * @author RenYang
	 */
	public boolean deleteDataCollectorData(Integer collectonData_ID);
	
	/**获得表中所有数据
	 * @return
	 * @author RenYang
	 */
	public List<DataCollectorData> findAllDataCollectorData();
	
	/**按日期获得采集器数据
	 * @return
	 * @author RenYang
	 */
    public List<DataCollectorData> findDataCollectorDataByDate(Date date);
    
    /**查询某个时间段的数据
     * @param date1
     * @param date2
     * @return
     */
    public List<DataCollectorData> findDataCollectorDataByDateBucket(Date date1,Date date2);
}
