package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.Addr;
import com.energyman.dao.AddrDao;
import com.energyman.service.IAddrService;

@Service
public class AddrService implements IAddrService{

	@Autowired
	AddrDao addrDao;
	
	@Override
	public Addr getAddrById(Integer addr_ID) {
		// TODO Auto-generated method stub
		return addrDao.selectByPrimaryKey(addr_ID);
	}

	@Override
	public boolean addAddr(Addr record) {
		// TODO Auto-generated method stub
		int result=addrDao.insert(record);
		if(result > 0){
			return true;
		}else{
			return false;
		}			
	}

	@Override
	public boolean updateAddr(Addr record) {
		// TODO Auto-generated method stub
		int result=addrDao.updateByPrimaryKeySelective(record);		
		if(result > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean deleteAddr(Integer addr_ID) {
		// TODO Auto-generated method stub
		int result=addrDao.deleteByPrimaryKey(addr_ID);
		if(result > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public List<Addr> findAllAddr() {
		// TODO Auto-generated method stub
		List<Addr> addrs=addrDao.selectAllAddr();
		return addrs;
	}

}
