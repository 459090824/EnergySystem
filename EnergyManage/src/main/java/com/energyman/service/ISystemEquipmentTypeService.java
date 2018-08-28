package com.energyman.service;

import java.util.List;

import com.energyman.bean.MeterType;
import com.energyman.bean.SystemEquipmentType;

public interface ISystemEquipmentTypeService {

	/**
	 * ͨ��ϵͳ�豸����ID�õ�������Ϣ
	 * @param systemEquipmentType_ID
	 * @return
	 * @author RenYang
	 */
	public SystemEquipmentType getSystemEquipmentTypeById(Integer systemEquipmentType_ID);
	/**
	 * ͨ��SystemEquipmentType����ϵͳ�豸����
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean addSystemEquipmentType(SystemEquipmentType record);
	/**
	 * ͨ��SystemEquipmentType�������ϵͳ�豸������Ϣ
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean updateSystemEquipmentType(SystemEquipmentType record);
	/**
	 * ͨ��systemEquipmentType_IDɾ��������Ϣ
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean deleteSystemEquipmentType(Integer systemEquipmentType_ID);
	/**
	 * ͨ��չʾ�鿴�������ͣ�ɾ�������ͳ��⣩
	 * @return
	 * @author RenYang
	 */
	public List<SystemEquipmentType> findAllSystemEquipmentType(Integer systemEquipmentState_ID);
}
