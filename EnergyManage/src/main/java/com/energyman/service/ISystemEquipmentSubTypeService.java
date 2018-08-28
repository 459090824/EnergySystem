package com.energyman.service;

import java.util.List;

import com.energyman.bean.SystemEquipmentSubType;

public interface ISystemEquipmentSubTypeService {
	
	/**
	 * ͨ��ϵͳ�豸������ID�õ�������Ϣ
	 * @param systemEquipmentSubType_ID
	 * @return
	 * @author RenYang
	 */
	public SystemEquipmentSubType getSystemEquipmentSubTypeById(Integer systemEquipmentSubType_ID);
	/**
	 * ͨ��SystemEquipmentSubType����ϵͳ�豸������
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean addSystemEquipmentSubType(SystemEquipmentSubType record);
	/**
	 * ͨ��SystemEquipmentSubType�������ϵͳ�豸��������Ϣ
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean updateSystemEquipmentSubType(SystemEquipmentSubType record);
	/**
	 * ͨ��systemEquipmentSubType_IDɾ��������Ϣ
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean deleteSystemEquipmentSubType(Integer systemEquipmentSubType_ID);
	/**
	 * ͨ��չʾ�鿴�������ͣ�ɾ���ĳ��⣩
	 * @return
	 * @author RenYang
	 */
	public List<SystemEquipmentSubType> findAllSystemEquipmentSubType(Integer systemEquipmentSubState_ID);
	
	/**
	 * ͨ���豸���ͻ��������Ӧ���豸�����ͣ�ɾ���ĳ��⣩
	 * @param systemEquipmentType_ID
	 * @return
	 */
	public List<SystemEquipmentSubType> selectSystemEquipmentSubTypeBySystemEquipmentType(Integer systemEquipmentType_ID,Integer systemEquipmentSubState_ID);
}
