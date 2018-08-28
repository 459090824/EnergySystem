package com.energyman.service;

import java.util.List;

import com.energyman.bean.EquipmentSubType;


public interface IEquipmentSubTypeService {
	
	/**ͨ��equipmentSubType_ID����豸������
	 * @param equipmentSubType_ID
	 * @return
	 * @author RenYang
	 */
	public EquipmentSubType getEquipmentSubTypeById(Integer equipmentSubType_ID);
	
	/**ͨ��ʵ���������豸��������Ϣ
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean updateEquipmentSubType(EquipmentSubType record);
		
	/**ͨ��equipmentSubType_IDɾ���豸������ 
	 * @param equipmentSubType_ID
	 * @return
	 * @author RenYang
	 */
	public boolean deleteEquipmentSubType(Integer equipmentSubType_ID);
	
	/**ͨ��ʵ���������豸������
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean addEquipmentSubType(EquipmentSubType record);
	
	/**��������豸�����ͣ�ɾ���ĳ��⣩
	 * @return
	 * @author RenYang
	 */
	public List<EquipmentSubType> findAllEquipmentSubType(Integer equipmentSubType_state);
	
	/**
	   * ��ѯ�豸��������δɾ�����豸������
	   * @param equipmentType_ID
	   * @return
	   */
	public List<EquipmentSubType> findEquipmentSubTypeByEquipmentType(Integer equipmentType_ID,Integer equipmentSubType_state);
}
