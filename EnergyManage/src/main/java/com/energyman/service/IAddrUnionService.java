package com.energyman.service;

import com.energyman.bean.AddrUnion;

public interface IAddrUnionService {
	
	/**
	 * 通过地址id获得详细地址信息
	 * @param addr_ID
	 * @return
	 */
	AddrUnion findAddrUnionByAddrId(Integer addr_ID);
}
