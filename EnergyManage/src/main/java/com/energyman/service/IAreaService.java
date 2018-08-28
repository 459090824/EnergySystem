package com.energyman.service;

import java.util.List;

import com.energyman.bean.Area;

public interface IAreaService {
	/**
	 * ͨ������ID�õ�������Ϣ
	 * @param Region_ID
	 * @return
	 * @author RenYang
	 */
	public Area getAreaById(Integer region_ID);
	/**
	 * ͨ��Area������������
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean addArea(Area record);
	/**
	 * ͨ��Area�������������Ϣ
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean updateArea(Area record);
	/**
	 * ͨ��Region_IDɾ������
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean deleteArea(Integer region_ID);
	/**
	 * ͨ��չʾ�鿴������Ϣ
	 * @return
	 * @author RenYang
	 */
	public List<Area> findAllArea();
	/**������Ӧ԰��������
	 * @param park_ID
	 * @return
	 * @author RenYang
	 */
	public List<Area> getAreaByPark(Integer park_ID);
}
