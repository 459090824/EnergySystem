package com.energyman.service;

import java.util.List;

import com.energyman.bean.BuildingType;

public interface IBuildingTypeService {
	
	/**
	 * ͨ��buildType_ID�õ�����������Ϣ
	 * @param  buildType_ID
	 * @return
	 * @author RenYang
	 */
	public BuildingType getBuildingTypeById(Integer buildType_ID);
	/**
	 * ͨ��BuildingType������½���������Ϣ
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean updateBuildingType(BuildingType record);
	/**
	 * ͨ��BuildingType�������ӽ�������
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean addBuildingType(BuildingType record);
	/**
	 * ͨ��buildType_IDɾ����������
	 * @param  buildType_ID
	 * @return
	 * @author RenYang
	 */
	public boolean deleteBuildingType(Integer buildType_ID);
	/**
	 * ��ѯ�õ����н���������Ϣ
	 * @param  
	 * @return
	 * @author RenYang
	 */
	public List<BuildingType> findAllBuildingType();
}
