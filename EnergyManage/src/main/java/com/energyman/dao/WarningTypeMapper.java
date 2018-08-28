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
    
    /** ��ѯ������о�������(ɾ���ĳ���)
     * @return
     * @author RenYang
     */
    List<WarningType> selectAllWarningType(Integer typestate);
}