package com.energyman.service;

import com.energyman.bean.Warning;

public interface IWarningService {

	/**
	 * ͨ��warningid�õ�������Ϣ
	 * @param  warningid
	 * @return
	 * @author RenYang
	 */
	public Warning getWarningById(Integer warningid);
	/**
	 * ͨ��Warning������¾�����Ϣ
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean updateWarning(Warning record);
	/**
	 * ͨ��Building�������Ӿ���
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean addWarning(Warning record);
	/**
	 * ͨ��warningidɾ������
	 * @param  warningid
	 * @return
	 * @author RenYang
	 */
	public boolean deleteWarning(Integer warningid);
}
