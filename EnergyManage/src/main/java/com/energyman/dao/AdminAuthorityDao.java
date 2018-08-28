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
	     * 通过权限id批量删除管理员拥有的权限
	     * @param authorityIds
	     * @return
	     */
	  int batchDelete(List<Integer> noteids);
	    
	    /**
	     * 批量插入权限
	     * @param record
	     * @return
	     * @author 
	     */
	  int batchInsert(List<AdminAuthority> record);
	  
	  /**
	   * 通过管理员id和权限id获得权限记录
	   * @param authorityid
	   * @param systemadminid
	   * @return
	   */
	  List<AdminAuthority> selectAuthorityIdByAdminIdAndAuthorityId(Integer authorityid, Integer systemadminid);
}
