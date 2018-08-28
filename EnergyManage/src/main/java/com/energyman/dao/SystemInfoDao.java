package com.energyman.dao;

import java.util.List;

import com.energyman.bean.SystemInfo;

public interface SystemInfoDao {
	
	int deleteByPrimaryKey(Integer inforID);

    int insert(SystemInfo record);

    int insertSelective(SystemInfo record);

    SystemInfo selectByPrimaryKey(Integer inforID);

    int updateByPrimaryKeySelective(SystemInfo record);

    int updateByPrimaryKey(SystemInfo record);
    
    /** ��ѯ�������ϵͳ��Ϣ
     * @return
     * @author RenYang
     */
    List<SystemInfo> selectAllSystemInfo();
    
    /**������ϵͳ��Ϣͳ��
     * @return
     */
    int countAllSystemInfo();
}
