package com.energyman.dao;

import java.util.List;

import com.energyman.bean.RoomUnion;

public interface RoomUnionMapper {

	/**联合查询获得房间所有信息
	 * @return
	 * @author RenYang
	 */
	List<RoomUnion> selectRoomUnionResult();
}
