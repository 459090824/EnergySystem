package com.energyman.service;

import com.energyman.bean.SuddenDispatch;

public interface ISudddenDispatchService {

	/**
	 * 通过dispatch_ID得到突发调度信息
	 * 
	 * @param dispatch_ID
	 * @return
	 * @author RenYang
	 */
	public SuddenDispatch getSuddenDispatchById(Integer dispatch_ID);

	/**
	 * 通过SuddenDispatch对象查找突发调度信息
	 * 
	 * @param SuddenDispatch
	 * @return
	 * @author RenYang
	 */
	public SuddenDispatch getSuddenDispatch(SuddenDispatch record);

	/**
	 * 通过SuddenDispatch对象更新调度信息
	 * 
	 * @param recod
	 * @return
	 * @author RenYang
	 */
	public boolean updateSuddenDispatch(SuddenDispatch record);

	/**
	 * 通过SuddenDispatch对象增加调度信息
	 * 
	 * @param recod
	 * @return
	 * @author RenYang
	 */
	public boolean addSuddenDispatch(SuddenDispatch record);

	/**
	 * 通过dispatch_ID删除调度信息
	 * 
	 * @param dispatch_ID
	 * @return
	 * @author RenYang
	 */
	public boolean deleteSuddenDispatch(Integer dispatch_ID);
}
