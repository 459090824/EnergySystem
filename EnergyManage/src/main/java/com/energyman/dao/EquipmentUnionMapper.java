package com.energyman.dao;

import java.util.List;

import com.energyman.bean.EquipmentUnion;

public interface EquipmentUnionMapper {
	
	/**联合查询获得设备所有信息(删除的设备除外)
	 * @return
	 * @author RenYang
	 */
	List<EquipmentUnion> selectEquipmentUnionResult(Integer state_ID);
	
	/**设置设备工作模式
	 * @param equipmentUnion
	 * @return
	 * @author RenYang
	 */
	int updateEquipmentHMModel(EquipmentUnion equipmentUnion);
	
	/**联合查询获得可以调度的设备
	 * @param equipmentUnion
	 * @return
	 * @author RenYang
	 */
	List<EquipmentUnion> selectDispatchEquipment(EquipmentUnion equipmentUnion);
	
	/**通过房间查询设备数量
	 * @param addr_Code
	 * @return
	 */
	int selectNumByAddr(Integer addr_Code);
	
	/**通过设备编号查询设备联合信息
	 * @param equipment_Code
	 * @return
	 */
	EquipmentUnion selectEquipmentByCode(Integer equipment_Code);
	
	/**通过设备控制模式查询设备
	 * @param equipmentControlModel_ID
	 * @return
	 */
	List<EquipmentUnion> selectEquipmentByModel(Integer equipmentControlModel_ID);
}
