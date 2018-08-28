package com.energyman.service;

import java.util.List;

import com.energyman.bean.EquipmentDispatch;

public interface IEquipmentDispatchService {
	
	/**
	 * ͨ��dispatch_ID�õ�������Ϣ
	 * @param  dispatch_ID
	 * @return
	 * @author RenYang
	 */
	public EquipmentDispatch getEquipmentDispatchById(Integer dispatch_ID);
	/**
	 * ͨ��EquipmentDispatch������ҵ�����Ϣ
	 * @param  EquipmentDispatch
	 * @return
	 * @author RenYang
	 */
	public EquipmentDispatch getEquipmentDispatch(EquipmentDispatch record);
	/**
	 * ͨ��EquipmentDispatch������µ�����Ϣ
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean updateEquipmentDispatch(EquipmentDispatch record);
	/**
	 * ͨ��EquipmentDispatch�������ӵ�����Ϣ
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean addEquipmentDispatch(EquipmentDispatch record);
	/**
	 * ͨ��dispatch_IDɾ��������Ϣ
	 * @param  dispatch_ID
	 * @return
	 * @author RenYang
	 */
	public boolean deleteEquipmentDispatch(Integer dispatch_ID);
	
	/**��ѯ���ڵ���״̬���豸
	 * @return
	 */
	public List<EquipmentDispatch> findAllEquipmentDispatch();
}
