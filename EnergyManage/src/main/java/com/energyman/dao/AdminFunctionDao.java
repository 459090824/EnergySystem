package com.energyman.dao;

import com.energyman.bean.AdminFunction;

public interface AdminFunctionDao {
	
	int deleteByPrimaryKey(Integer adminFunction_ID);

    int insert(AdminFunction record);

    int insertSelective(AdminFunction record);

    AdminFunction selectByPrimaryKey(Integer adminFunction_ID);

    int updateByPrimaryKeySelective(AdminFunction record);

    int updateByPrimaryKey(AdminFunction record);
}	
