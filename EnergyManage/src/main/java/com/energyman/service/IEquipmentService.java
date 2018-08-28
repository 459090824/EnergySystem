package com.energyman.service;

import java.util.List;

import com.energyman.bean.Equipment;


public interface IEquipmentService {
	/**
	 * ͨ��equipment_ID�õ��豸��Ϣ
	 * @param  equipment_ID
	 * @return
	 * @author RenYang
	 */
	public Equipment getEquipmentById(Integer equipment_ID);
	/**
	 * ͨ��Equipment��������豸
	 * @param  Equipment
	 * @return
	 * @author RenYang
	 */
	public Equipment getEquipment(Equipment record);
	/**
	 * ͨ��Equipment��������豸��Ϣ
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean updateEquipment(Equipment record);
	/**
	 * ͨ��Equipment���������豸
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean addEquipment(Equipment record);
	/**
	 * ͨ��equipment_IDɾ���豸
	 * @param  equipment_ID
	 * @return
	 * @author RenYang
	 */
	public boolean deleteEquipment(Integer equipment_ID);
	/**
	 * ��ѯ�õ������豸
	 * @param  
	 * @return
	 * @author RenYang
	 */
	public List<Equipment> findAllEquipment();
	
	/**
	 * ͳ���豸����
	 * @return
	 */
	public int countEquipmentTotal();
	
	/**
	 * ͨ���豸״̬ͳ���豸����
	 * @param state_ID
	 * @return
	 */
	public int countByState(Integer state_ID);
	
	/**
	 * ͨ���豸����ͳ���豸����
	 * @param equipmentType_ID
	 * @return
	 */
	public int selectCountByType(Integer equipmentType_ID);
	
	/**
	 * ͨ���豸������ͳ���豸����
	 * @param equipmentType_ID
	 * @return
	 */
	public int selectCountBySubType(Integer equipmentSubType_ID);
	
	/**ͨ��λ�û���豸����
	 * @param addr_ID
	 * @return
	 */
	public int selectCountByAddr(Integer addr_ID);

	/**ͨ���豸��Ż���豸��Ϣ
	 * @param equipment_Code
	 * @return
	 */
	public Equipment getEquipmentByEquipmentCode(Integer equipment_Code);

}
