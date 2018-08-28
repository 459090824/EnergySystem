package com.energyman.dao;

import com.energyman.bean.Warning;

public interface WarningMapper {
    int deleteByPrimaryKey(Integer warningid);

    int insert(Warning record);

    int insertSelective(Warning record);

    Warning selectByPrimaryKey(Integer warningid);

    int updateByPrimaryKeySelective(Warning record);

    int updateByPrimaryKey(Warning record);
}