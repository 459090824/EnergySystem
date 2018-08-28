package com.energyman.dao;

import java.util.List;

import com.energyman.bean.Room;

public interface RoomDao {
	int deleteByPrimaryKey(Integer room_ID);

    int insert(Room record);

    int insertSelective(Room record);

    Room selectByPrimaryKey(Integer room_ID);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);
    
    /** 查询获得所有房间
     * @return
     * @author RenYang
     */
    List<Room> selectAllRoom();
    
    /**
	 * 通过建筑查所对应的房间
	 * @param build_ID
	 * @return
	 */
	List<Room> selectByBuilding(Integer build_ID);
}
