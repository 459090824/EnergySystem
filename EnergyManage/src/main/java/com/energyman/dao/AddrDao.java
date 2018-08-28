package com.energyman.dao;

import java.util.List;

import com.energyman.bean.Addr;

public interface AddrDao {
	  int deleteByPrimaryKey(Integer addr_ID);

	  int insert(Addr record);

	  int insertSelective(Addr record);
	  
	  Addr selectByPrimaryKey(Integer addr_ID);
	  
	  int updateByPrimaryKeySelective(Addr record);

	  int updateByPrimaryKey(Addr record);
	  
	  /** 查询获得所有Addr
	     * @return
	     * @author RenYang
	     */
	  List<Addr> selectAllAddr();
	  
}
