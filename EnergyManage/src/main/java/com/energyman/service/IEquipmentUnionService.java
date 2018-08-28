package com.energyman.service;

import java.util.List;

import com.energyman.bean.EquipmentUnion;

public interface IEquipmentUnionService {
	
	/**
	 * ����豸����������Ϣ��ɾ�����豸���⣩
	 * @return
	 * @author RenYang
	 */
	public List<EquipmentUnion> findAllEquipmentUnion(Integer state_ID);
	
	/**�����豸����ģʽ
	 * @param equipmentUnion
	 * @return
	 * @author RenYang
	 */
	public boolean setEquipmentModel(EquipmentUnion equipmentUnion);
	
	/**
	 * ��ÿ��Ե��ȵ��豸��Ϣ
	 * @return
	 * @author RenYang
	 */
	public List<EquipmentUnion> findAllDispatchEquipment(EquipmentUnion equipmentUnion);
	
	/**
	 * ͨ������鵽�豸����
	 * @param addr_Code
	 * @return
	 */
	public int findNumByAddr(Integer addr_Code);
	
	/**ͨ���豸��Ż���豸���ϲ�ѯ��Ϣ
	 * @param equipment_Code
	 * @return
	 */
	public EquipmentUnion findEquipmentByCode(Integer equipment_Code);
	
	/**ͨ���豸����ģʽ��ѯ�豸
	 * @param equipmentControlModel_ID
	 * @return
	 */
	public List<EquipmentUnion> findEquipmentByModel(Integer equipmentControlModel_ID);
}
