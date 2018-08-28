package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.SuddenDispatchUnion;
import com.energyman.dao.SuddenDispatchUnionMapper;
import com.energyman.service.ISuddenDispatchUnionService;

@Service
public class SuddenDispatchUnionService implements ISuddenDispatchUnionService{

	@Autowired
	SuddenDispatchUnionMapper suddenDispatchUnionMapper;
	
	@Override
	public List<SuddenDispatchUnion> findSuddenDispatchUnionResult() {
		// TODO Auto-generated method stub
		return suddenDispatchUnionMapper.selectSuddenDispatchUnionResult();
	}

}
