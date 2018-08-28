package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.RoomUnion;
import com.energyman.dao.RoomUnionMapper;
import com.energyman.service.IRoomUnionService;

@Service
public class RoomUnionService implements IRoomUnionService {

	@Autowired
	RoomUnionMapper roomUnionMapper;
	
	@Override
	public List<RoomUnion> findAllRoomUnion() {
		// TODO Auto-generated method stub
		return roomUnionMapper.selectRoomUnionResult();
	}

}
