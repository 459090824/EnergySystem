package com.energyman.service;

import java.util.List;

import com.energyman.bean.Building;

public interface IBuildingService {
	
	/**
	 * ͨ��build_ID�õ�������Ϣ
	 * @param  build_ID
	 * @return
	 * @author RenYang
	 */
	public Building getBuildingById(Integer build_ID);
	/**
	 * ͨ��Building������½�����Ϣ
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean updateBuilding(Building record);
	/**
	 * ͨ��Building�������ӽ���
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean addBuilding(Building record);
	/**
	 * ͨ��build_IDɾ������
	 * @param  build_ID
	 * @return
	 * @author RenYang
	 */
	public boolean deleteBuilding(Integer build_ID);
	/**
	 * ��ѯ�õ����н�����Ϣ
	 * @param  
	 * @return
	 * @author RenYang
	 */
	public List<Building> findAllBuilding();
	
	/**������Ӧ԰��������
	 * @param region_ID
	 * @return
	 * @author RenYang
	 */
	public List<Building> getBuildingByArea(Integer region_ID);
}
