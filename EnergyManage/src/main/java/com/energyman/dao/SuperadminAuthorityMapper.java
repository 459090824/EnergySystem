package com.energyman.dao;

import com.energyman.bean.SuperadminAuthority;

public interface SuperadminAuthorityMapper {
    int deleteByPrimaryKey(Integer noteid);

    int insert(SuperadminAuthority record);

    int insertSelective(SuperadminAuthority record);

    SuperadminAuthority selectByPrimaryKey(Integer noteid);

    int updateByPrimaryKeySelective(SuperadminAuthority record);

    int updateByPrimaryKey(SuperadminAuthority record);
}