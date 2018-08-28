package com.energyman.service;

import java.util.List;

import com.energyman.bean.State;

public interface IStateService {
	/**
	 * ͨ��״̬ID�õ�״̬��Ϣ
	 * @param state_ID
	 * @return
	 * @author RenYang
	 */
	public State getStateById(Integer state_ID);
	/**
	 * ͨ��State��������״̬
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean addState(State record);
	/**
	 * ͨ��State�������״̬��Ϣ
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean updateState(State record);
	/**
	 * ͨ��state_IDɾ��״̬
	 * @param record
	 * @return
	 * @author RenYang
	 */
	public boolean deleteState(Integer state_ID);
	/**
	 * ͨ��չʾ�鿴����״̬��Ϣ
	 * @return
	 * @author RenYang
	 */
	public List<State> findAllState();
}
