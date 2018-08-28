package com.energyman.dao;

import java.util.List;

import com.energyman.bean.State;

public interface StateDao {
	int deleteByPrimaryKey(Integer state_ID);

    int insert(State record);

    int insertSelective(State record);

    State  selectByPrimaryKey(Integer state_ID);

    int updateByPrimaryKeySelective(State record);

    int updateByPrimaryKey(State record);
    
    /** 查询获得所有State
     * @return
     * @author RenYang
     */
    List<State> selectAllState();
}
