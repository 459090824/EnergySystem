package com.energyman.service;

import java.util.List;

import com.energyman.bean.SystemInfo;

public interface ISystemInfoService {
	

	/**
	 * ͨ��inforID�õ�ϵͳ��Ϣ��Ϣ
	 * @param  inforID
	 * @return
	 * @author RenYang
	 */
	public SystemInfo getSystemInfoById(Integer inforID);
	/**
	 * ͨ��SystemInfo�������ϵͳ��Ϣ��Ϣ
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean updateSystemInfo(SystemInfo record);
	/**
	 * ͨ��SystemInfo��������ϵͳ��Ϣ
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean addSystemInfo(SystemInfo record);
	/**
	 * ͨ��inforIDɾ��ϵͳ��Ϣ
	 * @param  inforID
	 * @return
	 * @author RenYang
	 */
	public boolean deleteSystemInfo(Integer inforID);
	/**
	 * ��ѯ�õ�����ϵͳ��Ϣ
	 * @param  
	 * @return
	 * @author RenYang
	 */
	public List<SystemInfo> findAllSystemInfo();
	
	/**ͳ��ϵͳ��Ϣ����
	 * @return
	 */
	public int countAllSystemInfo();
}
