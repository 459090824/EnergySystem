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
    
    /** 查询获得所有系统消息
     * @return
     * @author RenYang
     */
    List<SystemInfo> selectAllSystemInfo();
    
    /**对所有系统消息统计
     * @return
     */
    int countAllSystemInfo();
}
