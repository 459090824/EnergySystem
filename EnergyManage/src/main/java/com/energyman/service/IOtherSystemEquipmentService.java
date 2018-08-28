package com.energyman.service;

import com.energyman.bean.OtherSystemEquipment;

public interface IOtherSystemEquipmentService {
	
	/**
	 * ͨ��systemEquipmentID�õ�����ϵͳ�豸��Ϣ
	 * @param  systemEquipmentID
	 * @return
	 * @author RenYang
	 */
	public OtherSystemEquipment getOtherSystemEquipmentById(Integer systemEquipmentID);
	/**
	 * ͨ��OtherSystemEquipment�����������ϵͳ�豸��Ϣ
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean updateOtherSystemEquipment(OtherSystemEquipment record);
	/**
	 * ͨ��OtherSystemEquipment��������ϵͳ�豸
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean addOtherSystemEquipment(OtherSystemEquipment record);
	/**
	 * ͨ��systemEquipmentIDɾ������ϵͳ�豸
	 * @param  systemEquipmentID
	 * @return
	 * @author RenYang
	 */
	public boolean deleteOtherSystemEquipment(Integer systemEquipmentID);
}
