package com.energyman.dao;

import java.util.List;

import com.energyman.bean.Admin;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer systemadminid);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer systemadminid);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
    
    /** 查询获得所有admin
     * @return
     * @author RenYang
     */
    List<Admin> selectAllAdmin();
    
    /**
     * 用户名、密码 查找管理员
     * @param username
     * @param password
     * @return
     */
    Admin selectAdmin(String username, String password);
}