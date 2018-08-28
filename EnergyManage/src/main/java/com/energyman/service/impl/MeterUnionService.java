package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.MeterUnion;
import com.energyman.dao.MeterUnionMapper;
import com.energyman.service.IMeterUnionService;

@Service
public class MeterUnionService implements IMeterUnionService{

	@Autowired
	MeterUnionMapper meterUnionMapper;
	
	@Override
	public List<MeterUnion> findAllMeterUnion(Integer state_ID) {
		// TODO Auto-generated method stub
		return meterUnionMapper.selectMeterUnionResult(state_ID);
	}

}
