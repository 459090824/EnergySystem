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
	  
	  /**查询得到所有设备
	   * @return
	   * @author RenYang
	   */
	  List<Equipment> selectAllEquipment();
	  
	  /**统计系统设备数量
	   * @return
	   */
	  int selectCountTotal();
	  
	  /**通过设备状态，统计设备数量
	   * @param state_ID
	   * @return
	   */
	  int selectCountByState(Integer state_ID);
	  
	  /**通过设备类型，统计设备数量
	   * @param equipmentType_ID
	   * @return
	   */
	  int selectNumByType(Integer equipmentType_ID);
	  
	  /**通过设备子类型，统计设备数量
	   * @param equipmentType_ID
	   * @return
	   */
	  int selectNumBySubType(Integer equipmentSubType_ID);
	  
	  /**查询对应位置的设备数量
	   * @param addr_ID
	   * @return
	   */
	  int selectNumByAddr(Integer addr_ID);
	  
	  /**通过设备编号获得设备信息
	   * @param equipment_Code
	   * @return
	   */
	  Equipment selectByEquipmentCode(Integer equipment_Code);
}
