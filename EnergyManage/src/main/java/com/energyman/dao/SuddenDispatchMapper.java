package com.energyman.dao;

import com.energyman.bean.SuddenDispatch;

public interface SuddenDispatchMapper {
	
	  int deleteByPrimaryKey(Integer dispatch_ID);

	  int insert(SuddenDispatch record);

	  int insertSelective(SuddenDispatch record);
	  
	  SuddenDispatch selectByPrimaryKey(Integer dispatch_ID);
	  
	  int updateByPrimaryKeySelective(SuddenDispatch record);

	  int updateByPrimaryKey(SuddenDispatch record);
}
