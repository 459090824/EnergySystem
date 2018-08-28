package com.energyman.dao;

import java.util.List;

import com.energyman.bean.EquipmentUnion;

public interface EquipmentUnionMapper {
	
	/**���ϲ�ѯ����豸������Ϣ(ɾ�����豸����)
	 * @return
	 * @author RenYang
	 */
	List<EquipmentUnion> selectEquipmentUnionResult(Integer state_ID);
	
	/**�����豸����ģʽ
	 * @param equipmentUnion
	 * @return
	 * @author RenYang
	 */
	int updateEquipmentHMModel(EquipmentUnion equipmentUnion);
	
	/**���ϲ�ѯ��ÿ��Ե��ȵ��豸
	 * @param equipmentUnion
	 * @return
	 * @author RenYang
	 */
	List<EquipmentUnion> selectDispatchEquipment(EquipmentUnion equipmentUnion);
	
	/**ͨ�������ѯ�豸����
	 * @param addr_Code
	 * @return
	 */
	int selectNumByAddr(Integer addr_Code);
	
	/**ͨ���豸��Ų�ѯ�豸������Ϣ
	 * @param equipment_Code
	 * @return
	 */
	EquipmentUnion selectEquipmentByCode(Integer equipment_Code);
	
	/**ͨ���豸����ģʽ��ѯ�豸
	 * @param equipmentControlModel_ID
	 * @return
	 */
	List<EquipmentUnion> selectEquipmentByModel(Integer equipmentControlModel_ID);
}
