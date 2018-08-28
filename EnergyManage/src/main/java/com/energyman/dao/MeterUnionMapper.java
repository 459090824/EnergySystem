package com.energyman.dao;

import java.util.List;

import com.energyman.bean.MeterUnion;

public interface MeterUnionMapper {

	/**联表查询得到所有仪器信息(删除的除外)
	 * @return
	 * @author RenYang
	 */
	List<MeterUnion> selectMeterUnionResult(Integer state_ID);
}
