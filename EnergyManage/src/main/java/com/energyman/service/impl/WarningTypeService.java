package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.WarningType;
import com.energyman.dao.WarningTypeMapper;
import com.energyman.service.IWarningTypeService;

@Service
public class WarningTypeService implements IWarningTypeService{

	@Autowired
	WarningTypeMapper warningtypeMapper;
	
	@Override
	public WarningType getWarningTypeById(Integer warningtypeid) {
		// TODO Auto-generated method stub
		return warningtypeMapper.selectByPrimaryKey(warningtypeid);
	}

	@Override
	public boolean updateWarningType(WarningType record) {
		// TODO Auto-generated method stub
		int res=warningtypeMapper.updateByPrimaryKeySelective(record);
		if(res > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean addWarningType(WarningType record) {
		// TODO Auto-generated method stub
		int res=warningtypeMapper.insert(record);
		if(res > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean deleteWarningType(Integer warningtypeid) {
		// TODO Auto-generated method stub
		int res=warningtypeMapper.deleteByPrimaryKey(warningtypeid);
		if(res > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public List<WarningType> findAllWarningType(Integer typestate) {
		// TODO Auto-generated method stub
		return warningtypeMapper.selectAllWarningType(typestate);
	}

}
