package com.energyman.dao;

import java.util.List;

import com.energyman.bean.AddrType;

public interface AddrTypeDao {
	  int deleteByPrimaryKey(Integer addrType_ID);

	  int insert(AddrType record);

	  int insertSelective(AddrType record);
	  
	  AddrType selectByPrimaryKey(Integer addrType_ID);
	  
	  int updateByPrimaryKeySelective(AddrType record);

	  int updateByPrimaryKey(AddrType record);
	  
	  /** 查询获得所有AddrType
	     * @return
	     * @author RenYang
	     */
	  List<AddrType> selectAllAddrType();
}
