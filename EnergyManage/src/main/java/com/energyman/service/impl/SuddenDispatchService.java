package com.energyman.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.SuddenDispatch;
import com.energyman.dao.SuddenDispatchMapper;
import com.energyman.service.ISudddenDispatchService;

@Service
public class SuddenDispatchService implements ISudddenDispatchService{

	@Autowired
	SuddenDispatchMapper suddenDispatchMapper;
	
	@Override
	public SuddenDispatch getSuddenDispatchById(Integer dispatch_ID) {
		// TODO Auto-generated method stub
		return suddenDispatchMapper.selectByPrimaryKey(dispatch_ID);
	}

	@Override
	public SuddenDispatch getSuddenDispatch(SuddenDispatch record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateSuddenDispatch(SuddenDispatch record) {
		// TODO Auto-generated method stub
		int res = suddenDispatchMapper.updateByPrimaryKeySelective(record);
		if(res > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean addSuddenDispatch(SuddenDispatch record) {
		// TODO Auto-generated method stub
		int res = suddenDispatchMapper.insert(record);
		if(res > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean deleteSuddenDispatch(Integer dispatch_ID) {
		// TODO Auto-generated method stub
		int res = suddenDispatchMapper.deleteByPrimaryKey(dispatch_ID);
		if(res > 0){
			return true;
		}else{
			return false;
		}		
	}

}
