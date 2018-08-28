package com.energyman.service;

import java.util.Date;
import java.util.List;

import com.energyman.bean.DataCollectorData;

public interface IDataCollectorDataService {
	/**
	 * ͨ��collectonData_ID�õ����ݲɼ�������
	 * @param  collectonData_ID
	 * @return
	 * @author RenYang
	 */
	public DataCollectorData getDataCollectorDataById(Integer collectonData_ID);
	/**
	 * ͨ��DataCollectorData����������ݲɼ�������
	 * @param  DataCollectorData
	 * @return
	 * @author RenYang
	 */
	public DataCollectorData getDataCollectorData(DataCollectorData record);
	/**
	 * ͨ��DataCollectorData����������ݲɼ�������
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean updateDataCollectorData(DataCollectorData record);
	/**
	 * ͨ��DataCollectorData�����������ݲɼ�������
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean addDataCollectorData(DataCollectorData record);
	/**
	 * ͨ��collectonData_IDɾ�����ݲɼ�������
	 * @param  collectonData_ID
	 * @return
	 * @author RenYang
	 */
	public boolean deleteDataCollectorData(Integer collectonData_ID);
	
	/**��ñ�����������
	 * @return
	 * @author RenYang
	 */
	public List<DataCollectorData> findAllDataCollectorData();
	
	/**�����ڻ�òɼ�������
	 * @return
	 * @author RenYang
	 */
    public List<DataCollectorData> findDataCollectorDataByDate(Date date);
    
    /**��ѯĳ��ʱ��ε�����
     * @param date1
     * @param date2
     * @return
     */
    public List<DataCollectorData> findDataCollectorDataByDateBucket(Date date1,Date date2);
}
