package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.AddrType;
import com.energyman.dao.AddrTypeDao;
import com.energyman.service.IAddrTypeService;

@Service
public class AddrTypeService implements IAddrTypeService {

	@Autowired
	AddrTypeDao addrTypeDao;
	
	@Override
	public AddrType getAddrTypeById(Integer addrType_ID) {
		// TODO Auto-generated method stub
		return addrTypeDao.selectByPrimaryKey(addrType_ID);
	}

	@Override
	public boolean addAddrType(AddrType record) {
		// TODO Auto-generated method stub
		int result=addrTypeDao.insert(record);
		if(result > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean updateAddrType(AddrType record) {
		// TODO Auto-generated method stub
		int result=addrTypeDao.updateByPrimaryKeySelective(record);
		if(result > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean deleteAddrType(Integer addrType_ID) {
		// TODO Auto-generated method stub
		int result=addrTypeDao.deleteByPrimaryKey(addrType_ID);
		if(result > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public List<AddrType> findAllAddrType() {
		// TODO Auto-generated method stub
		List<AddrType> addrTypes=addrTypeDao.selectAllAddrType();
		return addrTypes;
	}

}
