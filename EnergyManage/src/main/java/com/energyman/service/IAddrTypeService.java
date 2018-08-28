package com.energyman.service;

import java.util.List;

import com.energyman.bean.AddrType;

public interface IAddrTypeService {
	
	/**
	 * ͨ����ַ����ID�õ���ַ������Ϣ
	 * @param addrType_ID
	 * @return
	 * @author RenYang
	 */
	public AddrType getAddrTypeById(Integer addrType_ID);
	/**
	 * ͨ��AddrType�������ӵ�ַ����
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean addAddrType(AddrType record);
	/**
	 * ͨ��AddrType������µ�ַ������Ϣ
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean updateAddrType(AddrType record);
	/**
	 * ͨ��addrType_IDɾ����ַ������Ϣ
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean deleteAddrType(Integer addrType_ID);
	/**
	 * ͨ��չʾ�鿴������Դ������Ϣ
	 * @return
	 * @author RenYang
	 */
	public List<AddrType> findAllAddrType();
}
