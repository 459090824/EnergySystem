package com.energyman.dao;

import java.util.List;

import com.energyman.bean.SensorUnion;

public interface SensorUnionMapper {

	
	/**联合查询获得传感器所有信息（删除的设备除外）
	 * @return
	 * @author RenYang
	 */
	List<SensorUnion> selectSensorUnionResult(Integer state_ID);
}
