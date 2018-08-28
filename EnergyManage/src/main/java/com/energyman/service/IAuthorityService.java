package com.energyman.service;

import java.util.List;

import com.energyman.bean.Authority;

public interface IAuthorityService {
	/**ͨ��authorityid���Ȩ����Ϣ
	 * @param authorityid
	 * @return
	 * @author RenYang
	 */
	public Authority getAuthorityById(Integer authorityid);
	
	/**
	 * ͨ��Authority������·ǿ�Ȩ����Ϣ
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean updateAuthoritySelecttive(Authority record);
	
	/**
	 * ͨ��Authority�����������Ȩ����Ϣ
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean updateAuthority(Authority record);
	
	/**
	 * ͨ��Authority��������Ȩ��
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean addAuthority(Authority record);
	
	/**
	 * ͨ��authorityidɾ��Ȩ��
	 * @param  authorityid
	 * @return
	 * @author RenYang
	 */
	public boolean deleteAdmin(Integer authorityid);
	
	/**
	 * ��ѯ�õ�����Ȩ����Ϣ
	 * @param  
	 * @return
	 * @author RenYang
	 */
	public List<Authority> findAllAuthority();
}
