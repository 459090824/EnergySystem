package com.energyman.service;

import java.util.List;

import com.energyman.bean.MeterType;

public interface IMeterTypeService {
	/**
	 * ͨ���Ǳ�����ID�õ�������Ϣ
	 * @param meterType_ID
	 * @return
	 * @author RenYang
	 */
	public MeterType getMeterTypeById(Integer meterType_ID);
	/**
	 * ͨ��MeterType���������Ǳ�����
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean addMeterType(MeterType record);
	/**
	 * ͨ��MeterType�������������Ϣ
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean updateMeterType(MeterType record);
	/**
	 * ͨ��meterType_IDɾ��������Ϣ
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean deleteMeterType(Integer meterType_ID);
	/**
	 * ͨ��չʾ�鿴��������
	 * @return
	 * @author RenYang
	 */
	public List<MeterType> findAllMeterType();
}
