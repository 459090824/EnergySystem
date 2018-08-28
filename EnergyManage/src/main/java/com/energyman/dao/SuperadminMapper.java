package com.energyman.dao;

import com.energyman.bean.Superadmin;

public interface SuperadminMapper {
    int deleteByPrimaryKey(Integer superadminid);

    int insert(Superadmin record);

    int insertSelective(Superadmin record);

    Superadmin selectByPrimaryKey(Integer superadminid);

    int updateByPrimaryKeySelective(Superadmin record);

    int updateByPrimaryKey(Superadmin record);
}