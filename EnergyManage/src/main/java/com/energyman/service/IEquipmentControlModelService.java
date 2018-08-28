package com.energyman.service;

import java.util.List;

import com.energyman.bean.EquipmentControlModel;

public interface IEquipmentControlModelService {
	/**
	 * 通过控制模式ID得到模式信息
	 * @param equipmentControlModel_ID
	 * @return
	 * @author RenYang
	 */
	public EquipmentControlModel getEquipmentControlModelById(Integer equipmentControlModel_ID);
	/**
	 * 通过EquipmentControlModel对象增加控制模式
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean addEquipmentControlModel(EquipmentControlModel record);
	/**
	 * 通过EquipmentControlModel对象更新控制模式
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean updateEquipmentControlModel(EquipmentControlModel record);
	/**
	 * 通过equipmentControlModel_ID删除控制模式
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean deleteEquipmentControlModel(Integer equipmentControlModel_ID);
	/**
	 * 通过展示查看所有模式信息
	 * @return
	 * @author RenYang
	 */
	public List<EquipmentControlModel> findAllEquipmentControlModel();
}
