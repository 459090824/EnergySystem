package com.energyman.service;

import java.util.List;

import com.energyman.bean.WarningType;

public interface IWarningTypeService {

	/**
	 * 通过warningtypeid得到警报类型信息
	 * @param  warningtypeid
	 * @return
	 * @author RenYang
	 */
	public WarningType getWarningTypeById(Integer warningtypeid);
	/**
	 * 通过WarningType对象更新警报类型信息
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean updateWarningType(WarningType record);
	/**
	 * 通过WarningType对象增加警报类型
	 * @param  recod
	 * @return
	 * @author RenYang
	 */
	public boolean addWarningType(WarningType record);
	/**
	 * 通过warningtypeid删除警报类型
	 * @param  warningtypeid
	 * @return
	 * @author RenYang
	 */
	public boolean deleteWarningType(Integer warningtypeid);
	/**
	 * 查询得到所有警报类型信息（删除的除外）
	 * @param  
	 * @return
	 * @author RenYang
	 */
	public List<WarningType> findAllWarningType(Integer typestate);
}
