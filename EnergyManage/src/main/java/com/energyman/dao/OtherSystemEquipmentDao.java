package com.energyman.dao;

import com.energyman.bean.OtherSystemEquipment;

public interface OtherSystemEquipmentDao {
	
	int deleteByPrimaryKey(Integer systemEquipmentID);

    int insert(OtherSystemEquipment record);

    int insertSelective(OtherSystemEquipment record);

    OtherSystemEquipment selectByPrimaryKey(Integer systemEquipmentID);

    int updateByPrimaryKeySelective(OtherSystemEquipment record);

    int updateByPrimaryKey(OtherSystemEquipment record);
}
