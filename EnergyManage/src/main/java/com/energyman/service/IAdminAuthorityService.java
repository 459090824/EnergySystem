package com.energyman.service;


import java.util.List;

import com.energyman.bean.AdminAuthority;
import com.energyman.bean.AdminAuthorityUnion;

public interface IAdminAuthorityService {
	
	/**ͨ����¼id�õ�����ԱȨ����Ϣ
	 * @param noteid
	 * @return
	 * @author RenYang
	 */
	public AdminAuthority getAdminAuthorityById(Integer noteid);
	
	/**ͨ��record���ӹ���ԱȨ����Ϣ
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean addAdminAuthority(AdminAuthority record);
	
	/**ͨ��noteidɾ������ԱȨ����Ϣ
	 * @param noteid
	 * @return
	 * @author RenYang
	 */
	public boolean deleteAdminAuthority(Integer noteid);
	
	
	 /**
	   * ͨ������Աid��Ȩ��id���Ȩ�޼�¼
	   * @param authorityid
	   * @param systemadminid
	   * @return
	   */
	List<Integer> findAuthorityIdByAdminIdAndAuthorityId(Integer authorityid, Integer systemadminid);

	
	
	
	/**
	 * ͨ������Աid��ѯ����Աӵ�еĺ�̨����Ȩ��
	 * @param systemadminid
	 * @return
	 */
	List<AdminAuthorityUnion> selectAdminFunctionAuthorityByAdminId(Integer systemadminid);
	
    /**
     * ͨ������Աӵ��Ȩ�ޱ��id����ɾ������Աӵ�е�Ȩ��
     * @param noteids
     * @return
     */
    boolean batchDelete(List<Integer> noteids);
    
	/**
	 * ��������ĳ����Աӵ�е�Ȩ��
	 * @param authorities
	 * @return
	 * @author
	 */
	boolean saveRoleOwnAuthorityList(List<AdminAuthority> authorities);
}
