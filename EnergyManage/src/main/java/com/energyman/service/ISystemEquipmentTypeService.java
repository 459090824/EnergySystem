package com.energyman.service;

import java.util.List;

import com.energyman.bean.MeterType;
import com.energyman.bean.SystemEquipmentType;

public interface ISystemEquipmentTypeService {

	/**
	 * 通过系统设备类型ID得到类型信息
	 * @param systemEquipmentType_ID
	 * @return
	 * @author RenYang
	 */
	public SystemEquipmentType getSystemEquipmentTypeById(Integer systemEquipmentType_ID);
	/**
	 * 通过SystemEquipmentType对象系统设备类型
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean addSystemEquipmentType(SystemEquipmentType record);
	/**
	 * 通过SystemEquipmentType对象更新系统设备类型信息
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean updateSystemEquipmentType(SystemEquipmentType record);
	/**
	 * 通过systemEquipmentType_ID删除类型信息
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean deleteSystemEquipmentType(Integer systemEquipmentType_ID);
	/**
	 * 通过展示查看所有类型（删除的类型除外）
	 * @return
	 * @author RenYang
	 */
	public List<SystemEquipmentType> findAllSystemEquipmentType(Integer systemEquipmentState_ID);
}
