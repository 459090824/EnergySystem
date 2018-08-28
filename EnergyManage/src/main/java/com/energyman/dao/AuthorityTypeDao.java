package com.energyman.dao;

import com.energyman.bean.AuthorityType;

public interface AuthorityTypeDao {
	
	int deleteByPrimaryKey(Integer authorityType_ID);

    int insert(AuthorityType record);

    int insertSelective(AuthorityType record);

    AuthorityType selectByPrimaryKey(Integer authorityType_ID);

    int updateByPrimaryKeySelective(AuthorityType record);

    int updateByPrimaryKey(AuthorityType record);
}
