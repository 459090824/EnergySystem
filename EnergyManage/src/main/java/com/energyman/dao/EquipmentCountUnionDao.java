package com.energyman.dao;

import com.energyman.bean.EquipmentCountUnion;

public interface EquipmentCountUnionDao {
	
	/**ͨ�������ѯ�豸����
	 * @param room_ID
	 * @return
	 */
	int countEquipmentByRoom(Integer room_ID);
	
	/**ͨ��������ѯ�豸����
	 * @param build_ID
	 * @return
	 */
	int countEquipmentByBuilding(Integer build_ID);
	
	/**ͨ�������ѯ�豸����
	 * @param region_ID
	 * @return
	 */
	int countEquipmentByArea(Integer region_ID);
	
	/**ͨ���豸��Ų��豸��Ϣ��������ַ�ȣ�
	 * @param equipment_Code
	 * @return
	 */
	EquipmentCountUnion selectEquipmentByCode(Integer equipment_Code);
}
