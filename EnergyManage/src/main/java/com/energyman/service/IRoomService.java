package com.energyman.service;

import java.util.List;

import com.energyman.bean.Room;

public interface IRoomService {
	/**
	 * ͨ��room_ID�õ�������Ϣ
	 * @param  room_ID
	 * @return
	 * @author RenYang
	 */
	public Room getRoomById(Integer room_ID);
	/**
	 * ͨ��Room������·�����Ϣ
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean updateRoom(Room record);
	/**
	 * ͨ��Room�������ӷ���
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean addRoom(Room record);
	/**
	 * ͨ��build_IDɾ������
	 * @param  build_ID
	 * @return
	 * @author RenYang
	 */
	public boolean deleteRoom(Integer room_ID);
	/**
	 * ��ѯ�õ����з�����Ϣ
	 * @param  
	 * @return
	 * @author RenYang
	 */
	public List<Room> findAllRoom();
	
	/**������Ӧ�����ķ���
	 * @param build_ID
	 * @return
	 * @author RenYang
	 */
	public List<Room> getRoomByBuilding(Integer build_ID);
}
