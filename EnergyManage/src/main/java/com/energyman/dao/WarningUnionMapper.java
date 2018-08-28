package com.energyman.dao;

import java.util.List;

import com.energyman.bean.WarningUnion;

public interface WarningUnionMapper {

	/**联合查询获得警告所有信息
	 * @return
	 * @author RenYang
	 */
	List<WarningUnion> selectWarningUnionResult();
}
