package com.energyman.dao;

import java.util.List;

import com.energyman.bean.Authority;

public interface AuthorityMapper {
    int deleteByPrimaryKey(Integer authorityid);

    int insert(Authority record);

    int insertSelective(Authority record);

    Authority selectByPrimaryKey(Integer authorityid);

    int updateByPrimaryKeySelective(Authority record);

    int updateByPrimaryKey(Authority record);
    
    /** 查询获得所有权限
     * @return
     * @author RenYang
     */
    List<Authority> selectAllAuthority();
}