package com.energyman.service;

import java.util.List;

import com.energyman.bean.DataCollector;

public interface IDataCollectorService {

	/**
	 * ͨ��collection_ID�õ����ݲɼ�����Ϣ
	 * @param  collection_ID
	 * @return
	 * @author RenYang
	 */
	public DataCollector getDataCollectorById(Integer collection_ID);
	/**
	 * ͨ��DataCollector����������ݲɼ���
	 * @param  DataCollector
	 * @return
	 * @author RenYang
	 */
	public DataCollector getDataCollector(DataCollector record);
	/**
	 * ͨ��DataCollector����������ݲɼ�����Ϣ
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean updateDataCollector(DataCollector record);
	/**
	 * ͨ��DataCollector�����������ݲɼ���
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean addDataCollector(DataCollector record);
	/**
	 * ͨ��collection_IDɾ�����ݲɼ���
	 * @param  collection_ID
	 * @return
	 * @author RenYang
	 */
	public boolean deleteDataCollector(Integer collection_ID);
	/**
	 * ��ѯ�õ��������ݲɼ���
	 * @param  
	 * @return
	 * @author RenYang
	 */
	public List<DataCollector> findAllDataCollector();
}
