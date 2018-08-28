package com.energyman.dao;

import java.util.List;

import com.energyman.bean.DataCollectorUnion;

public interface DataCollectorUnionDao {

	/**联合查询获得设备所有信息(删除的除外)
	 * @return
	 * @author RenYang
	 */
	List<DataCollectorUnion> selectDataCollectorUnionResult(Integer state_ID);
}
