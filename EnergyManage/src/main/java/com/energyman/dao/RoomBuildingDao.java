package com.energyman.dao;

import java.util.List;

import com.energyman.bean.RoomBuildingUnion;

public interface RoomBuildingDao {

	
	/**房间和建筑信息联合查询
	 * @return
	 */
	List<RoomBuildingUnion> selectRoomBuildingUnion();
}
