package com.energyman.service;

import com.energyman.bean.EquipmentCountUnion;

public interface IEquipmentCountUnionService {
	
	/**ͨ������ͳ���豸����
	 * @param room_ID
	 * @return
	 */
	public int findcountEquipmentByRoom(Integer room_ID);
	
	/**ͨ������ͳ���豸����
	 * @param build_ID
	 * @return
	 */
	public int findcountEquipmentByBuilding(Integer build_ID);
	
	/**ͨ������ͳ���豸����
	 * @param region_ID
	 * @return
	 */
	public int findcountEquipmentByArea(Integer region_ID);
	
	/**ͨ���豸��Ų��豸��Ϣ��������ַ����Ϣ��
	 * @param equipment_Code
	 * @return
	 */
	public EquipmentCountUnion findEquipmentByCode(Integer equipment_Code);
}
