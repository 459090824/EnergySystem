package com.energyman.dao;

import java.util.List;

import com.energyman.bean.RoomBuildingUnion;

public interface RoomBuildingDao {

	
	/**����ͽ�����Ϣ���ϲ�ѯ
	 * @return
	 */
	List<RoomBuildingUnion> selectRoomBuildingUnion();
}
