package com.energyman.service;

import com.energyman.bean.AddrUnion;

public interface IAddrUnionService {
	
	/**
	 * ͨ����ַid�����ϸ��ַ��Ϣ
	 * @param addr_ID
	 * @return
	 */
	AddrUnion findAddrUnionByAddrId(Integer addr_ID);
}
