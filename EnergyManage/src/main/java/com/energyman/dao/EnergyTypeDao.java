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
	  
	  /**��ѯ��������Դ��Ϣ
	   * @return
	   * @author RenYang
	   */
	  List<EnergyType> selectAllEnergyType();
	  
	  /**����Դ���ͽ���ͳ��
	   * @return
	   */
	  int selectCountEnergyType();
}
