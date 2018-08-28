package com.energyman.service;

import java.util.List;

import com.energyman.bean.Meter;

public interface IMeterService {

	/**
	 * ͨ��meter_ID�õ�������Ϣ
	 * @param  meter_ID
	 * @return
	 * @author RenYang
	 */
	public Meter getMeterById(Integer meter_ID);
	/**
	 * ͨ��Meter�����������
	 * @param  Meter
	 * @return
	 * @author RenYang
	 */
	public Meter getMeter(Meter record);
	/**
	 * ͨ��Meter�������������Ϣ
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean updateMeter(Meter record);
	/**
	 * ͨ��Meter������������
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean addMeter(Meter record);
	/**
	 * ͨ��meter_IDɾ������
	 * @param  meter_ID
	 * @return
	 * @author RenYang
	 */
	public boolean deleteMeter(Integer meter_ID);
	/**
	 * ��ѯ�õ���������
	 * @param  
	 * @return
	 * @author RenYang
	 */
	public List<Meter> findAllMeter();
}
