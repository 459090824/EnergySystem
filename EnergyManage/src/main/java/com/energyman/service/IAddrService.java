package com.energyman.service;

import java.util.List;

import com.energyman.bean.Addr;

public interface IAddrService {
	
	/**
	 * 通过地址ID得到地址信息
	 * @param addrType_ID
	 * @return
	 * @author RenYang
	 */
	public Addr getAddrById(Integer addr_ID);
	/**
	 * 通过Addr对象增加地址
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean addAddr(Addr record);
	/**
	 * 通过Addr对象更新地址信息
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean updateAddr(Addr record);
	/**
	 * 通过addr_ID删除地址信息
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean deleteAddr(Integer addr_ID);
	/**
	 * 通过展示查看所有地址信息
	 * @return
	 * @author RenYang
	 */
	public List<Addr> findAllAddr();
}
