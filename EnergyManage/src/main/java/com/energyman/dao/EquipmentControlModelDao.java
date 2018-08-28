package com.energyman.dao;

import java.util.List;

import com.energyman.bean.EquipmentControlModel;

public interface EquipmentControlModelDao {
	  int deleteByPrimaryKey(Integer equipmentControlModel_ID);

	  int insert(EquipmentControlModel record);

	  int insertSelective(EquipmentControlModel record);
	  
	  EquipmentControlModel selectByPrimaryKey(Integer equipmentControlModel_ID);
	  
	  int updateByPrimaryKeySelective(EquipmentControlModel record);

	  int updateByPrimaryKey(EquipmentControlModel record);
	  
	  /** 查询获得所有EquipmentControlModel
	     * @return
	     * @author RenYang
	     */
	  List<EquipmentControlModel> selectAllEquipmentControlModel();
	}
