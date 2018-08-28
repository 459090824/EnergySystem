package com.energyman.service;

import java.util.List;

import com.energyman.bean.AddrType;

public interface IAddrTypeService {
	
	/**
	 * 通过地址类型ID得到地址类型信息
	 * @param addrType_ID
	 * @return
	 * @author RenYang
	 */
	public AddrType getAddrTypeById(Integer addrType_ID);
	/**
	 * 通过AddrType对象增加地址类型
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean addAddrType(AddrType record);
	/**
	 * 通过AddrType对象更新地址类型信息
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean updateAddrType(AddrType record);
	/**
	 * 通过addrType_ID删除地址类型信息
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean deleteAddrType(Integer addrType_ID);
	/**
	 * 通过展示查看所有能源类型信息
	 * @return
	 * @author RenYang
	 */
	public List<AddrType> findAllAddrType();
}
