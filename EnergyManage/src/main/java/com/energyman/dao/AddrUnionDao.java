package com.energyman.dao;

import com.energyman.bean.AddrUnion;

public interface AddrUnionDao {
	
	/**
	 * ͨ����ַid�����ϸ��ַ��Ϣ
	 * @param addr_ID
	 * @return
	 */
	AddrUnion selectAddrUnionByAddrId(Integer addr_ID);
}
