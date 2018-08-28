package com.energyman.service;

import com.energyman.bean.OtherSystemEquipment;

public interface IOtherSystemEquipmentService {
	
	/**
	 * 通过systemEquipmentID得到其它系统设备信息
	 * @param  systemEquipmentID
	 * @return
	 * @author RenYang
	 */
	public OtherSystemEquipment getOtherSystemEquipmentById(Integer systemEquipmentID);
	/**
	 * 通过OtherSystemEquipment对象更新其他系统设备信息
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean updateOtherSystemEquipment(OtherSystemEquipment record);
	/**
	 * 通过OtherSystemEquipment对象其他系统设备
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean addOtherSystemEquipment(OtherSystemEquipment record);
	/**
	 * 通过systemEquipmentID删除其他系统设备
	 * @param  systemEquipmentID
	 * @return
	 * @author RenYang
	 */
	public boolean deleteOtherSystemEquipment(Integer systemEquipmentID);
}
