package com.energyman.service;

import java.util.List;

import com.energyman.bean.WarningType;

public interface IWarningTypeService {

	/**
	 * ͨ��warningtypeid�õ�����������Ϣ
	 * @param  warningtypeid
	 * @return
	 * @author RenYang
	 */
	public WarningType getWarningTypeById(Integer warningtypeid);
	/**
	 * ͨ��WarningType������¾���������Ϣ
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean updateWarningType(WarningType record);
	/**
	 * ͨ��WarningType�������Ӿ�������
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean addWarningType(WarningType record);
	/**
	 * ͨ��warningtypeidɾ����������
	 * @param  warningtypeid
	 * @return
	 * @author RenYang
	 */
	public boolean deleteWarningType(Integer warningtypeid);
	/**
	 * ��ѯ�õ����о���������Ϣ��ɾ���ĳ��⣩
	 * @param  
	 * @return
	 * @author RenYang
	 */
	public List<WarningType> findAllWarningType(Integer typestate);
}
