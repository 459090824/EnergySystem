package com.energyman.dao;

import java.util.List;

import com.energyman.bean.Building;

public interface BuildingDao {
	  int deleteByPrimaryKey(Integer build_ID);

	  int insert(Building record);

	  int insertSelective(Building record);
	  
	  Building selectByPrimaryKey(Integer build_ID);
	  
	  int updateByPrimaryKeySelective(Building record);

	  int updateByPrimaryKey(Building record);
	  
	  /** ��ѯ������н���
	     * @return
	     * @author RenYang
	     */
	  List<Building> selectAllBuilidng();
	  
	  /**
	   * ͨ�����������Ӧ�Ľ���
	   * @param park_ID
	   * @return
	   */
	  List<Building> selectByArea(Integer region_ID);
}
