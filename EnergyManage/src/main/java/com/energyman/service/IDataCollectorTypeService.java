package com.energyman.service;

import java.util.List;

import com.energyman.bean.DataCollectorType;

public interface IDataCollectorTypeService {

	/**
	 * ͨ�����ݲɼ�������ID�õ�������Ϣ
	 * @param collectionType_ID
	 * @return
	 * @author RenYang
	 */
	public DataCollectorType getDataCollectorTypeById(Integer collectionType_ID);
	/**
	 * ͨ��DataCollectorType�������Ӳɼ�������
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean addDataCollectorType(DataCollectorType record);
	/**
	 * ͨ��MeterType�������������Ϣ
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean updateDataCollectorType(DataCollectorType record);
	/**
	 * ͨ��collectionType_IDɾ��������Ϣ
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean deleteDataCollectorType(Integer collectionType_ID);
	/**
	 * ͨ��չʾ�鿴��������
	 * @return
	 * @author RenYang
	 */
	public List<DataCollectorType> findAllDataCollectorType();
}
