package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.RoomBuildingUnion;
import com.energyman.dao.RoomBuildingDao;
import com.energyman.service.IRoomBuildingUnionService;

@Service
public class RoomBuildingUnionService implements IRoomBuildingUnionService{

	@Autowired
	RoomBuildingDao roomBuildingDao;
	
	@Override
	public List<RoomBuildingUnion> findRoomBuildingUnion() {
		// TODO Auto-generated method stub
		return roomBuildingDao.selectRoomBuildingUnion();
	}

}
