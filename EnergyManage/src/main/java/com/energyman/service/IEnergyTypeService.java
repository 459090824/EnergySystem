package com.energyman.service;

import java.util.List;

import com.energyman.bean.EnergyType;

public interface IEnergyTypeService {
	/**
	 * 通过区域ID得到能源信息
	 * @param energyType_ID
	 * @return
	 * @author RenYang
	 */
	public EnergyType getEnergyTypeById(Integer energyType_ID);
	/**
	 * 通过EnergyType对象增加能源
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean addEnergyType(EnergyType record);
	/**
	 * 通过EnergyType对象更新能源信息
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean updateEnergyType(EnergyType record);
	/**
	 * 通过energyType_ID删除能源信息
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean deleteEnergyType(Integer energyType_ID);
	/**
	 * 通过展示查看所有能源信息
	 * @return
	 * @author RenYang
	 */
	public List<EnergyType> findAllEnergyType();
	
	/**
	 * 对能源类型进行统计
	 * @return
	 */
	public int findCountEnergyType();
}
