package com.energyman.service;


import java.util.List;

import com.energyman.bean.AdminAuthority;
import com.energyman.bean.AdminAuthorityUnion;

public interface IAdminAuthorityService {
	
	/**通过记录id得到管理员权限信息
	 * @param noteid
	 * @return
	 * @author RenYang
	 */
	public AdminAuthority getAdminAuthorityById(Integer noteid);
	
	/**通过record增加管理员权限信息
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean addAdminAuthority(AdminAuthority record);
	
	/**通过noteid删除管理员权限信息
	 * @param noteid
	 * @return
	 * @author RenYang
	 */
	public boolean deleteAdminAuthority(Integer noteid);
	
	
	 /**
	   * 通过管理员id和权限id获得权限记录
	   * @param authorityid
	   * @param systemadminid
	   * @return
	   */
	List<Integer> findAuthorityIdByAdminIdAndAuthorityId(Integer authorityid, Integer systemadminid);

	
	
	
	/**
	 * 通过管理员id查询管理员拥有的后台功能权限
	 * @param systemadminid
	 * @return
	 */
	List<AdminAuthorityUnion> selectAdminFunctionAuthorityByAdminId(Integer systemadminid);
	
    /**
     * 通过管理员拥有权限表的id批量删除管理员拥有的权限
     * @param noteids
     * @return
     */
    boolean batchDelete(List<Integer> noteids);
    
	/**
	 * 批量保存某管理员拥有的权限
	 * @param authorities
	 * @return
	 * @author
	 */
	boolean saveRoleOwnAuthorityList(List<AdminAuthority> authorities);
}
