package com.energyman.service;

import java.util.List;

import com.energyman.bean.Admin;

public interface IAdminService {
	/**
	 * ͨ��ϵͳ����Աid�õ�ϵͳ����Ա��Ϣ
	 * @param  systemadminid
	 * @return
	 * @author RenYang
	 */
	public Admin getAdminById(Integer systemadminid);
	/**
	 * ͨ��Admin�������ϵͳ����Ա
	 * @param  systemadminid
	 * @return
	 * @author RenYang
	 */
	public Admin getAdmin(Admin record);
	/**
	 * ͨ��Admin�������ϵͳ����Ա��Ϣ
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean updateAdmin(Admin record);
	/**
	 * ͨ��Admin��������ϵͳ����Ա
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean addAdmin(Admin record);
	/**
	 * ͨ��systemadminid����ɾ��ϵͳ����Ա
	 * @param  systemadminid
	 * @return
	 * @author RenYang
	 */
	public boolean deleteAdmin(Integer systemadminid);
	/**
	 * ��ѯ�õ�����ϵͳ����Ա
	 * @param  
	 * @return
	 * @author RenYang
	 */
	public List<Admin> findAllAdmin();
	
	/**
     * �û��������� ���ҹ���Ա
     * @param username
     * @param password
     * @return
     */
    Admin findAdmin(String username, String password);
}
