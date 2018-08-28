package com.energyman.service;

import java.util.List;

import com.energyman.bean.SystemInfo;

public interface ISystemInfoService {
	

	/**
	 * 通过inforID得到系统消息信息
	 * @param  inforID
	 * @return
	 * @author RenYang
	 */
	public SystemInfo getSystemInfoById(Integer inforID);
	/**
	 * 通过SystemInfo对象更新系统消息信息
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean updateSystemInfo(SystemInfo record);
	/**
	 * 通过SystemInfo对象增加系统消息
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean addSystemInfo(SystemInfo record);
	/**
	 * 通过inforID删除系统消息
	 * @param  inforID
	 * @return
	 * @author RenYang
	 */
	public boolean deleteSystemInfo(Integer inforID);
	/**
	 * 查询得到所有系统消息
	 * @param  
	 * @return
	 * @author RenYang
	 */
	public List<SystemInfo> findAllSystemInfo();
	
	/**统计系统消息数量
	 * @return
	 */
	public int countAllSystemInfo();
}
