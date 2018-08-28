package com.energyman.service;

import java.util.List;

import com.energyman.bean.Room;

public interface IRoomService {
	/**
	 * 通过room_ID得到房间信息
	 * @param  room_ID
	 * @return
	 * @author RenYang
	 */
	public Room getRoomById(Integer room_ID);
	/**
	 * 通过Room对象更新房间信息
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean updateRoom(Room record);
	/**
	 * 通过Room对象增加房间
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean addRoom(Room record);
	/**
	 * 通过build_ID删除房间
	 * @param  build_ID
	 * @return
	 * @author RenYang
	 */
	public boolean deleteRoom(Integer room_ID);
	/**
	 * 查询得到所有房间信息
	 * @param  
	 * @return
	 * @author RenYang
	 */
	public List<Room> findAllRoom();
	
	/**获得相对应建筑的房间
	 * @param build_ID
	 * @return
	 * @author RenYang
	 */
	public List<Room> getRoomByBuilding(Integer build_ID);
}
