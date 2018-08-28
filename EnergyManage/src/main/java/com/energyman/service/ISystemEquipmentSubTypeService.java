package com.energyman.service;

import java.util.List;

import com.energyman.bean.SystemEquipmentSubType;

public interface ISystemEquipmentSubTypeService {
	
	/**
	 * 通过系统设备子类型ID得到类型信息
	 * @param systemEquipmentSubType_ID
	 * @return
	 * @author RenYang
	 */
	public SystemEquipmentSubType getSystemEquipmentSubTypeById(Integer systemEquipmentSubType_ID);
	/**
	 * 通过SystemEquipmentSubType对象系统设备子类型
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean addSystemEquipmentSubType(SystemEquipmentSubType record);
	/**
	 * 通过SystemEquipmentSubType对象更新系统设备子类型信息
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean updateSystemEquipmentSubType(SystemEquipmentSubType record);
	/**
	 * 通过systemEquipmentSubType_ID删除类型信息
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean deleteSystemEquipmentSubType(Integer systemEquipmentSubType_ID);
	/**
	 * 通过展示查看所有类型（删除的除外）
	 * @return
	 * @author RenYang
	 */
	public List<SystemEquipmentSubType> findAllSystemEquipmentSubType(Integer systemEquipmentSubState_ID);
	
	/**
	 * 通过设备类型获得其所对应的设备子类型（删除的除外）
	 * @param systemEquipmentType_ID
	 * @return
	 */
	public List<SystemEquipmentSubType> selectSystemEquipmentSubTypeBySystemEquipmentType(Integer systemEquipmentType_ID,Integer systemEquipmentSubState_ID);
}
