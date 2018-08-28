package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.Room;
import com.energyman.dao.RoomDao;
import com.energyman.service.IRoomService;

@Service
public class RoomService implements IRoomService {

	@Autowired
	RoomDao roomDao;
	
	@Override
	public Room getRoomById(Integer room_ID) {
		// TODO Auto-generated method stub
		return roomDao.selectByPrimaryKey(room_ID);
	}

	@Override
	public List<Room> findAllRoom() {
		// TODO Auto-generated method stub
		List<Room> rooms=roomDao.selectAllRoom();
		return rooms;
	}

	@Override
	public List<Room> getRoomByBuilding(Integer build_ID) {
		// TODO Auto-generated method stub
		return roomDao.selectByBuilding(build_ID);
	}

	@Override
	public boolean updateRoom(Room record) {
		// TODO Auto-generated method stub
		int res=roomDao.updateByPrimaryKeySelective(record);
		if(res > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean addRoom(Room record) {
		// TODO Auto-generated method stub
		int res=roomDao.insert(record);
		if(res > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public boolean deleteRoom(Integer room_ID) {
		// TODO Auto-generated method stub
		int res=roomDao.deleteByPrimaryKey(room_ID);
		if(res > 0){
			return true;
		}else{
			return false;
		}		
	}
	
}
