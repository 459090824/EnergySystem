package com.energyman.dao;

import java.util.List;

import com.energyman.bean.EnergyType;

public interface EnergyTypeDao {
	  int deleteByPrimaryKey(Integer energyType_ID);

	  int insert(EnergyType record);

	  int insertSelective(EnergyType record);
	  
	  EnergyType selectByPrimaryKey(Integer energyType_ID);
	  
	  int updateByPrimaryKeySelective(EnergyType record);

	  int updateByPrimaryKey(EnergyType record);
	  
	  /**查询到所有能源信息
	   * @return
	   * @author RenYang
	   */
	  List<EnergyType> selectAllEnergyType();
	  
	  /**对能源类型进行统计
	   * @return
	   */
	  int selectCountEnergyType();
}
