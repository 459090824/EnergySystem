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
    
    /** ��ѯ�������admin
     * @return
     * @author RenYang
     */
    List<Admin> selectAllAdmin();
    
    /**
     * �û��������� ���ҹ���Ա
     * @param username
     * @param password
     * @return
     */
    Admin selectAdmin(String username, String password);
}