package com.energyman.service;

import java.util.List;

import com.energyman.bean.EquipmentType;

public interface IEquipmentTypeService {

	/**通过equipmentType_ID获得设备父类型
	 * @param equipmentType_ID
	 * @return
	 * @author RenYang
	 */
	public EquipmentType getEquipmentTypeById(Integer equipmentType_ID);
	
	/**通过实体对象更新设备父类型信息
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean updateEquipmentType(EquipmentType record);
		
	/**通过equipmentType_ID删除设备父类型 
	 * @param equipmentType_ID
	 * @return
	 * @author RenYang
	 */
	public boolean deleteEquipmentType(Integer equipmentType_ID);
	
	/**通过实体对象添加设备父类型
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean addEquipmentType(EquipmentType record);
	
	/**获得所有设备类型（删除的除外）
	 * @return
	 * @author RenYang
	 */
	public List<EquipmentType> findAllEquipmentType(Integer equipmentType_state);
}
