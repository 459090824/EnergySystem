package com.energyman.dao;

import com.energyman.bean.EquipmentCountUnion;

public interface EquipmentCountUnionDao {
	
	/**通过房间查询设备数量
	 * @param room_ID
	 * @return
	 */
	int countEquipmentByRoom(Integer room_ID);
	
	/**通过建筑查询设备数量
	 * @param build_ID
	 * @return
	 */
	int countEquipmentByBuilding(Integer build_ID);
	
	/**通过区域查询设备数量
	 * @param region_ID
	 * @return
	 */
	int countEquipmentByArea(Integer region_ID);
	
	/**通过设备编号查设备信息（包括地址等）
	 * @param equipment_Code
	 * @return
	 */
	EquipmentCountUnion selectEquipmentByCode(Integer equipment_Code);
}
