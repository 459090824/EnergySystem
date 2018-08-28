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
    
    /** ��ѯ������з���
     * @return
     * @author RenYang
     */
    List<Room> selectAllRoom();
    
    /**
	 * ͨ������������Ӧ�ķ���
	 * @param build_ID
	 * @return
	 */
	List<Room> selectByBuilding(Integer build_ID);
}
