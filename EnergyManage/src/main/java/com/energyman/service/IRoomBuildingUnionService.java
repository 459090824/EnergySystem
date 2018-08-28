package com.energyman.service;

import java.util.List;

import com.energyman.bean.RoomBuildingUnion;

public interface IRoomBuildingUnionService {

	/**获得联合查询结果
	 * @return
	 */
	public List<RoomBuildingUnion> findRoomBuildingUnion();
}
