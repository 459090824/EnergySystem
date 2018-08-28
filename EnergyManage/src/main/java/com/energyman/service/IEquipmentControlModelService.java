package com.energyman.service;

import java.util.List;

import com.energyman.bean.EquipmentControlModel;

public interface IEquipmentControlModelService {
	/**
	 * ͨ������ģʽID�õ�ģʽ��Ϣ
	 * @param equipmentControlModel_ID
	 * @return
	 * @author RenYang
	 */
	public EquipmentControlModel getEquipmentControlModelById(Integer equipmentControlModel_ID);
	/**
	 * ͨ��EquipmentControlModel�������ӿ���ģʽ
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean addEquipmentControlModel(EquipmentControlModel record);
	/**
	 * ͨ��EquipmentControlModel������¿���ģʽ
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean updateEquipmentControlModel(EquipmentControlModel record);
	/**
	 * ͨ��equipmentControlModel_IDɾ������ģʽ
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean deleteEquipmentControlModel(Integer equipmentControlModel_ID);
	/**
	 * ͨ��չʾ�鿴����ģʽ��Ϣ
	 * @return
	 * @author RenYang
	 */
	public List<EquipmentControlModel> findAllEquipmentControlModel();
}
