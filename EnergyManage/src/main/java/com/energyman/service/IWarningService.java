package com.energyman.service;

import com.energyman.bean.Warning;

public interface IWarningService {

	/**
	 * 通过warningid得到警报信息
	 * @param  warningid
	 * @return
	 * @author RenYang
	 */
	public Warning getWarningById(Integer warningid);
	/**
	 * 通过Warning对象更新警告信息
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean updateWarning(Warning record);
	/**
	 * 通过Building对象增加警告
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean addWarning(Warning record);
	/**
	 * 通过warningid删除警告
	 * @param  warningid
	 * @return
	 * @author RenYang
	 */
	public boolean deleteWarning(Integer warningid);
}
