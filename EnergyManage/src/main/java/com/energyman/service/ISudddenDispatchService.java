package com.energyman.service;

import com.energyman.bean.SuddenDispatch;

public interface ISudddenDispatchService {

	/**
	 * ͨ��dispatch_ID�õ�ͻ��������Ϣ
	 * 
	 * @param dispatch_ID
	 * @return
	 * @author RenYang
	 */
	public SuddenDispatch getSuddenDispatchById(Integer dispatch_ID);

	/**
	 * ͨ��SuddenDispatch�������ͻ��������Ϣ
	 * 
	 * @param SuddenDispatch
	 * @return
	 * @author RenYang
	 */
	public SuddenDispatch getSuddenDispatch(SuddenDispatch record);

	/**
	 * ͨ��SuddenDispatch������µ�����Ϣ
	 * 
	 * @param recod
	 * @return
	 * @author RenYang
	 */
	public boolean updateSuddenDispatch(SuddenDispatch record);

	/**
	 * ͨ��SuddenDispatch�������ӵ�����Ϣ
	 * 
	 * @param recod
	 * @return
	 * @author RenYang
	 */
	public boolean addSuddenDispatch(SuddenDispatch record);

	/**
	 * ͨ��dispatch_IDɾ��������Ϣ
	 * 
	 * @param dispatch_ID
	 * @return
	 * @author RenYang
	 */
	public boolean deleteSuddenDispatch(Integer dispatch_ID);
}
