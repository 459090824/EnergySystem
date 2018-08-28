package com.energyman.service;

import java.util.List;

import com.energyman.bean.EquipmentSubType;


public interface IEquipmentSubTypeService {
	
	/**通过equipmentSubType_ID获得设备父类型
	 * @param equipmentSubType_ID
	 * @return
	 * @author RenYang
	 */
	public EquipmentSubType getEquipmentSubTypeById(Integer equipmentSubType_ID);
	
	/**通过实体对象更新设备子类型信息
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean updateEquipmentSubType(EquipmentSubType record);
		
	/**通过equipmentSubType_ID删除设备父类型 
	 * @param equipmentSubType_ID
	 * @return
	 * @author RenYang
	 */
	public boolean deleteEquipmentSubType(Integer equipmentSubType_ID);
	
	/**通过实体对象添加设备子类型
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean addEquipmentSubType(EquipmentSubType record);
	
	/**获得所有设备子类型（删除的除外）
	 * @return
	 * @author RenYang
	 */
	public List<EquipmentSubType> findAllEquipmentSubType(Integer equipmentSubType_state);
	
	/**
	   * 查询设备类型所属未删除的设备子类型
	   * @param equipmentType_ID
	   * @return
	   */
	public List<EquipmentSubType> findEquipmentSubTypeByEquipmentType(Integer equipmentType_ID,Integer equipmentSubType_state);
}
