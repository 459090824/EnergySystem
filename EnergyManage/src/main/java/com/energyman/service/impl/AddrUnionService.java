package com.energyman.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.AddrUnion;
import com.energyman.dao.AddrUnionDao;
import com.energyman.service.IAddrUnionService;

@Service
public class AddrUnionService implements IAddrUnionService{

	@Autowired
	AddrUnionDao addrUnionDao;
	
	@Override
	public AddrUnion findAddrUnionByAddrId(Integer addr_ID) {
		// TODO Auto-generated method stub
		return addrUnionDao.selectAddrUnionByAddrId(addr_ID);
	}

}
