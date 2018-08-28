package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.State;
import com.energyman.dao.StateDao;
import com.energyman.service.IStateService;

@Service
public class StateService implements IStateService{

	@Autowired
	StateDao stateDao;
	
	@Override
	public State getStateById(Integer state_ID) {
		// TODO Auto-generated method stub
		return stateDao.selectByPrimaryKey(state_ID);
	}

	@Override
	public boolean addState(State record) {
		// TODO Auto-generated method stub
		int result=stateDao.insert(record);
		if(result > 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateState(State record) {
		// TODO Auto-generated method stub
		int result=stateDao.updateByPrimaryKeySelective(record);
		if(result > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean deleteState(Integer state_ID) {
		// TODO Auto-generated method stub
		int result=stateDao.deleteByPrimaryKey(state_ID);
		if(result > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public List<State> findAllState() {
		// TODO Auto-generated method stub
		return stateDao.selectAllState();
	}

}
