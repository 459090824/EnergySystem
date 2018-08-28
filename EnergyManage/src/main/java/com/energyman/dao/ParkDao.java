package com.energyman.dao;

import java.util.List;

import com.energyman.bean.Park;

public interface ParkDao {
	  int deleteByPrimaryKey(Integer park_ID);

	  int insert(Park record);

	  int insertSelective(Park record);
	  
	  Park selectByPrimaryKey(Integer park_ID);
	  
	  int updateByPrimaryKeySelective(Park record);

	  int updateByPrimaryKey(Park record);
	  
	  /**��ѯ����԰����Ϣ
	   * @return
	   * @author RenYang
	   */
	  List<Park> selectAllPark();
}
