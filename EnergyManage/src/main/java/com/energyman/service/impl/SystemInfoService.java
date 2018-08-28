package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.SystemInfo;
import com.energyman.dao.SystemInfoDao;
import com.energyman.service.ISystemInfoService;

@Service
public class SystemInfoService implements ISystemInfoService{

	@Autowired
	SystemInfoDao systemInfoDao;
	
	@Override
	public SystemInfo getSystemInfoById(Integer inforID) {
		// TODO Auto-generated method stub
		return systemInfoDao.selectByPrimaryKey(inforID);
	}

	@Override
	public boolean updateSystemInfo(SystemInfo record) {
		// TODO Auto-generated method stub
		int res =systemInfoDao.updateByPrimaryKeySelective(record);
		if(res > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean addSystemInfo(SystemInfo record) {
		// TODO Auto-generated method stub
		int res = systemInfoDao.insert(record);
		if(res > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean deleteSystemInfo(Integer inforID) {
		// TODO Auto-generated method stub
		int res = systemInfoDao.deleteByPrimaryKey(inforID);
		if(res > 0){
			return true;
		}else{
			return false;
		}	
	}

	@Override
	public List<SystemInfo> findAllSystemInfo() {
		// TODO Auto-generated method stub
		return systemInfoDao.selectAllSystemInfo();
	}

	@Override
	public int countAllSystemInfo() {
		// TODO Auto-generated method stub
		return systemInfoDao.countAllSystemInfo();
	}

}
