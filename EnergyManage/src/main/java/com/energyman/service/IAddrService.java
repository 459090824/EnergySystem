package com.energyman.service;

import java.util.List;

import com.energyman.bean.Addr;

public interface IAddrService {
	
	/**
	 * ͨ����ַID�õ���ַ��Ϣ
	 * @param addrType_ID
	 * @return
	 * @author RenYang
	 */
	public Addr getAddrById(Integer addr_ID);
	/**
	 * ͨ��Addr�������ӵ�ַ
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean addAddr(Addr record);
	/**
	 * ͨ��Addr������µ�ַ��Ϣ
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean updateAddr(Addr record);
	/**
	 * ͨ��addr_IDɾ����ַ��Ϣ
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean deleteAddr(Integer addr_ID);
	/**
	 * ͨ��չʾ�鿴���е�ַ��Ϣ
	 * @return
	 * @author RenYang
	 */
	public List<Addr> findAllAddr();
}
