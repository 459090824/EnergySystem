package com.energyman.dao;

import java.util.List;

import com.energyman.bean.AdminAuthority;

public interface AdminAuthorityDao {
	
	  int deleteByPrimaryKey(Integer noteid);

	  int insert(AdminAuthority record);

	  int insertSelective(AdminAuthority record);
	  
	  AdminAuthority selectByPrimaryKey(Integer noteid);
	  
	  int updateByPrimaryKeySelective(AdminAuthority record);

	  int updateByPrimaryKey(AdminAuthority record);
	  
	  /**
	     * ͨ��Ȩ��id����ɾ������Աӵ�е�Ȩ��
	     * @param authorityIds
	     * @return
	     */
	  int batchDelete(List<Integer> noteids);
	    
	    /**
	     * ��������Ȩ��
	     * @param record
	     * @return
	     * @author 
	     */
	  int batchInsert(List<AdminAuthority> record);
	  
	  /**
	   * ͨ������Աid��Ȩ��id���Ȩ�޼�¼
	   * @param authorityid
	   * @param systemadminid
	   * @return
	   */
	  List<AdminAuthority> selectAuthorityIdByAdminIdAndAuthorityId(Integer authorityid, Integer systemadminid);
}
