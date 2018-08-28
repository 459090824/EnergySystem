package com.energyman.dao;

import java.util.List;

import com.energyman.bean.WarningType;

public interface WarningTypeMapper {
    int deleteByPrimaryKey(Integer warningtypeid);

    int insert(WarningType record);

    int insertSelective(WarningType record);

    WarningType selectByPrimaryKey(Integer warningtypeid);

    int updateByPrimaryKeySelective(WarningType record);

    int updateByPrimaryKey(WarningType record);
    
    /** 查询获得所有警报类型(删除的除外)
     * @return
     * @author RenYang
     */
    List<WarningType> selectAllWarningType(Integer typestate);
}