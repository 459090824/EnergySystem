package com.energyman.service;

import com.energyman.bean.EquipmentCountUnion;

public interface IEquipmentCountUnionService {
	
	/**通过房间统计设备数量
	 * @param room_ID
	 * @return
	 */
	public int findcountEquipmentByRoom(Integer room_ID);
	
	/**通过建筑统计设备数量
	 * @param build_ID
	 * @return
	 */
	public int findcountEquipmentByBuilding(Integer build_ID);
	
	/**通过区域统计设备数量
	 * @param region_ID
	 * @return
	 */
	public int findcountEquipmentByArea(Integer region_ID);
	
	/**通过设备编号查设备信息（包括地址等信息）
	 * @param equipment_Code
	 * @return
	 */
	public EquipmentCountUnion findEquipmentByCode(Integer equipment_Code);
}
