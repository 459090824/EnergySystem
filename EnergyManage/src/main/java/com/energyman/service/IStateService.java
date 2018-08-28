package com.energyman.service;

import java.util.List;

import com.energyman.bean.State;

public interface IStateService {
	/**
	 * 通过状态ID得到状态信息
	 * @param state_ID
	 * @return
	 * @author RenYang
	 */
	public State getStateById(Integer state_ID);
	/**
	 * 通过State对象增加状态
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean addState(State record);
	/**
	 * 通过State对象更新状态信息
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean updateState(State record);
	/**
	 * 通过state_ID删除状态
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean deleteState(Integer state_ID);
	/**
	 * 通过展示查看所有状态信息
	 * @return
	 * @author RenYang
	 */
	public List<State> findAllState();
}
