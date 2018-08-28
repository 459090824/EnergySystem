package com.energyman.dao;

import java.util.List;

import com.energyman.bean.BuildingType;

public interface BuildingTypeDao {
	  int deleteByPrimaryKey(Integer buildType_ID);

	  int insert(BuildingType record);

	  int insertSelective(BuildingType record);
	  
	  BuildingType selectByPrimaryKey(Integer buildType_ID);
	  
	  int updateByPrimaryKeySelective(BuildingType record);

	  int updateByPrimaryKey(BuildingType record);
	  
	  /** ��ѯ������н���
	     * @return
	     * @author RenYang
	     */
	  List<BuildingType> selectAllBuildingType();
	  
}
