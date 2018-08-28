package com.energyman.service;

import java.util.List;

import com.energyman.bean.EquipmentDispatch;

public interface IEquipmentDispatchService {
	
	/**
	 * 通过dispatch_ID得到调度信息
	 * @param  dispatch_ID
	 * @return
	 * @author RenYang
	 */
	public EquipmentDispatch getEquipmentDispatchById(Integer dispatch_ID);
	/**
	 * 通过EquipmentDispatch对象查找调度信息
	 * @param  EquipmentDispatch
	 * @return
	 * @author RenYang
	 */
	public EquipmentDispatch getEquipmentDispatch(EquipmentDispatch record);
	/**
	 * 通过EquipmentDispatch对象更新调度信息
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean updateEquipmentDispatch(EquipmentDispatch record);
	/**
	 * 通过EquipmentDispatch对象增加调度信息
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean addEquipmentDispatch(EquipmentDispatch record);
	/**
	 * 通过dispatch_ID删除调度信息
	 * @param  dispatch_ID
	 * @return
	 * @author RenYang
	 */
	public boolean deleteEquipmentDispatch(Integer dispatch_ID);
	
	/**查询处于调度状态的设备
	 * @return
	 */
	public List<EquipmentDispatch> findAllEquipmentDispatch();
}
