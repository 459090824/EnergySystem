package com.energyman.dao;

import com.energyman.bean.AddrUnion;

public interface AddrUnionDao {
	
	/**
	 * 通过地址id获得详细地址信息
	 * @param addr_ID
	 * @return
	 */
	AddrUnion selectAddrUnionByAddrId(Integer addr_ID);
}
