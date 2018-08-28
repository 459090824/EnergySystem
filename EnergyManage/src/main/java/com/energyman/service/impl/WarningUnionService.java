package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.WarningUnion;
import com.energyman.dao.WarningUnionMapper;
import com.energyman.service.IWarningUnionService;

@Service
public class WarningUnionService implements IWarningUnionService{

	@Autowired
	WarningUnionMapper warningUnionMapper;
	
	@Override
	public List<WarningUnion> findAllWarningUnion() {
		// TODO Auto-generated method stub
		return warningUnionMapper.selectWarningUnionResult();
	}

}
