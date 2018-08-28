package com.energyman.service;

import java.util.List;

import com.energyman.bean.EquipmentUnion;

public interface IEquipmentUnionService {
	
	/**
	 * 获得设备联表所有信息（删除的设备除外）
	 * @return
	 * @author RenYang
	 */
	public List<EquipmentUnion> findAllEquipmentUnion(Integer state_ID);
	
	/**设置设备工作模式
	 * @param equipmentUnion
	 * @return
	 * @author RenYang
	 */
	public boolean setEquipmentModel(EquipmentUnion equipmentUnion);
	
	/**
	 * 获得可以调度的设备信息
	 * @return
	 * @author RenYang
	 */
	public List<EquipmentUnion> findAllDispatchEquipment(EquipmentUnion equipmentUnion);
	
	/**
	 * 通过房间查到设备数量
	 * @param addr_Code
	 * @return
	 */
	public int findNumByAddr(Integer addr_Code);
	
	/**通过设备编号获得设备联合查询信息
	 * @param equipment_Code
	 * @return
	 */
	public EquipmentUnion findEquipmentByCode(Integer equipment_Code);
	
	/**通过设备控制模式查询设备
	 * @param equipmentControlModel_ID
	 * @return
	 */
	public List<EquipmentUnion> findEquipmentByModel(Integer equipmentControlModel_ID);
}
