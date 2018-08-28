package com.energyman.service;

import java.util.List;

import com.energyman.bean.EnergyType;

public interface IEnergyTypeService {
	/**
	 * ͨ������ID�õ���Դ��Ϣ
	 * @param energyType_ID
	 * @return
	 * @author RenYang
	 */
	public EnergyType getEnergyTypeById(Integer energyType_ID);
	/**
	 * ͨ��EnergyType����������Դ
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean addEnergyType(EnergyType record);
	/**
	 * ͨ��EnergyType���������Դ��Ϣ
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean updateEnergyType(EnergyType record);
	/**
	 * ͨ��energyType_IDɾ����Դ��Ϣ
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean deleteEnergyType(Integer energyType_ID);
	/**
	 * ͨ��չʾ�鿴������Դ��Ϣ
	 * @return
	 * @author RenYang
	 */
	public List<EnergyType> findAllEnergyType();
	
	/**
	 * ����Դ���ͽ���ͳ��
	 * @return
	 */
	public int findCountEnergyType();
}
