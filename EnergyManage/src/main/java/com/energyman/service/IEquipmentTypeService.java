package com.energyman.service;

import java.util.List;

import com.energyman.bean.EquipmentType;

public interface IEquipmentTypeService {

	/**ͨ��equipmentType_ID����豸������
	 * @param equipmentType_ID
	 * @return
	 * @author RenYang
	 */
	public EquipmentType getEquipmentTypeById(Integer equipmentType_ID);
	
	/**ͨ��ʵ���������豸��������Ϣ
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean updateEquipmentType(EquipmentType record);
		
	/**ͨ��equipmentType_IDɾ���豸������ 
	 * @param equipmentType_ID
	 * @return
	 * @author RenYang
	 */
	public boolean deleteEquipmentType(Integer equipmentType_ID);
	
	/**ͨ��ʵ���������豸������
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean addEquipmentType(EquipmentType record);
	
	/**��������豸���ͣ�ɾ���ĳ��⣩
	 * @return
	 * @author RenYang
	 */
	public List<EquipmentType> findAllEquipmentType(Integer equipmentType_state);
}
