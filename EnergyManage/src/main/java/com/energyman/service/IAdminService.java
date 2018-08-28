package com.energyman.service;

import java.util.List;

import com.energyman.bean.Admin;

public interface IAdminService {
	/**
	 * 通过系统管理员id得到系统管理员信息
	 * @param  systemadminid
	 * @return
	 * @author RenYang
	 */
	public Admin getAdminById(Integer systemadminid);
	/**
	 * 通过Admin对象查找系统管理员
	 * @param  systemadminid
	 * @return
	 * @author RenYang
	 */
	public Admin getAdmin(Admin record);
	/**
	 * 通过Admin对象更新系统管理员信息
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean updateAdmin(Admin record);
	/**
	 * 通过Admin对象增加系统管理员
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean addAdmin(Admin record);
	/**
	 * 通过systemadminid对象删除系统管理员
	 * @param  systemadminid
	 * @return
	 * @author RenYang
	 */
	public boolean deleteAdmin(Integer systemadminid);
	/**
	 * 查询得到所有系统管理员
	 * @param  
	 * @return
	 * @author RenYang
	 */
	public List<Admin> findAllAdmin();
	
	/**
     * 用户名、密码 查找管理员
     * @param username
     * @param password
     * @return
     */
    Admin findAdmin(String username, String password);
}
