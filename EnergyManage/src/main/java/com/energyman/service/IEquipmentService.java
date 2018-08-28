package com.energyman.service;

import java.util.List;

import com.energyman.bean.Equipment;


public interface IEquipmentService {
	/**
	 * 通过equipment_ID得到设备信息
	 * @param  equipment_ID
	 * @return
	 * @author RenYang
	 */
	public Equipment getEquipmentById(Integer equipment_ID);
	/**
	 * 通过Equipment对象查找设备
	 * @param  Equipment
	 * @return
	 * @author RenYang
	 */
	public Equipment getEquipment(Equipment record);
	/**
	 * 通过Equipment对象更新设备信息
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean updateEquipment(Equipment record);
	/**
	 * 通过Equipment对象增加设备
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean addEquipment(Equipment record);
	/**
	 * 通过equipment_ID删除设备
	 * @param  equipment_ID
	 * @return
	 * @author RenYang
	 */
	public boolean deleteEquipment(Integer equipment_ID);
	/**
	 * 查询得到所有设备
	 * @param  
	 * @return
	 * @author RenYang
	 */
	public List<Equipment> findAllEquipment();
	
	/**
	 * 统计设备数量
	 * @return
	 */
	public int countEquipmentTotal();
	
	/**
	 * 通过设备状态统计设备数量
	 * @param state_ID
	 * @return
	 */
	public int countByState(Integer state_ID);
	
	/**
	 * 通过设备类型统计设备数量
	 * @param equipmentType_ID
	 * @return
	 */
	public int selectCountByType(Integer equipmentType_ID);
	
	/**
	 * 通过设备子类型统计设备数量
	 * @param equipmentType_ID
	 * @return
	 */
	public int selectCountBySubType(Integer equipmentSubType_ID);
	
	/**通过位置获得设备数量
	 * @param addr_ID
	 * @return
	 */
	public int selectCountByAddr(Integer addr_ID);

	/**通过设备编号获得设备信息
	 * @param equipment_Code
	 * @return
	 */
	public Equipment getEquipmentByEquipmentCode(Integer equipment_Code);

}
