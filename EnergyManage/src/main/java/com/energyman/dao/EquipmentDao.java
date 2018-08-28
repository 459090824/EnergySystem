package com.energyman.dao;

import java.util.List;

import com.energyman.bean.Equipment;

public interface EquipmentDao {
	  int deleteByPrimaryKey(Integer equipment_ID);

	  int insert(Equipment record);

	  int insertSelective(Equipment record);
	  
	  Equipment selectByPrimaryKey(Integer equipment_ID);
	  
	  int updateByPrimaryKeySelective(Equipment record);

	  int updateByPrimaryKey(Equipment record);
	  
	  /**��ѯ�õ������豸
	   * @return
	   * @author RenYang
	   */
	  List<Equipment> selectAllEquipment();
	  
	  /**ͳ��ϵͳ�豸����
	   * @return
	   */
	  int selectCountTotal();
	  
	  /**ͨ���豸״̬��ͳ���豸����
	   * @param state_ID
	   * @return
	   */
	  int selectCountByState(Integer state_ID);
	  
	  /**ͨ���豸���ͣ�ͳ���豸����
	   * @param equipmentType_ID
	   * @return
	   */
	  int selectNumByType(Integer equipmentType_ID);
	  
	  /**ͨ���豸�����ͣ�ͳ���豸����
	   * @param equipmentType_ID
	   * @return
	   */
	  int selectNumBySubType(Integer equipmentSubType_ID);
	  
	  /**��ѯ��Ӧλ�õ��豸����
	   * @param addr_ID
	   * @return
	   */
	  int selectNumByAddr(Integer addr_ID);
	  
	  /**ͨ���豸��Ż���豸��Ϣ
	   * @param equipment_Code
	   * @return
	   */
	  Equipment selectByEquipmentCode(Integer equipment_Code);
}
