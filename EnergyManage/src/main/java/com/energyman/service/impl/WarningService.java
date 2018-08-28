package com.energyman.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.Warning;
import com.energyman.dao.WarningMapper;
import com.energyman.service.IWarningService;

@Service
public class WarningService implements IWarningService{

	@Autowired
	WarningMapper warningMapper;
	
	@Override
	public Warning getWarningById(Integer warningid) {
		// TODO Auto-generated method stub
		return warningMapper.selectByPrimaryKey(warningid);
	}

	@Override
	public boolean updateWarning(Warning record) {
		// TODO Auto-generated method stub
		int res = warningMapper.updateByPrimaryKeySelective(record);
		if(res > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean addWarning(Warning record) {
		// TODO Auto-generated method stub
		int res = warningMapper.insert(record);
		if(res > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean deleteWarning(Integer warningid) {
		// TODO Auto-generated method stub
		int res = warningMapper.deleteByPrimaryKey(warningid);
		if(res > 0){
			return true;
		}else{
			return false;
		}		
	}

}
