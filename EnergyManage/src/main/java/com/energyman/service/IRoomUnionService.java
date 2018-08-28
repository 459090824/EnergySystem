package com.energyman.service;

import java.util.List;

import com.energyman.bean.RoomUnion;

public interface IRoomUnionService {

	/**
	 * 获得房间联表所有信息
	 * @return
	 * @author RenYang
	 */
	public List<RoomUnion> findAllRoomUnion();
}
