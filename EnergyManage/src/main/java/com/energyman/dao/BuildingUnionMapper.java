package com.energyman.dao;

import java.util.List;

import com.energyman.bean.BuildingUnion;

public interface BuildingUnionMapper {

	/**联合查询获得建筑所有信息
	 * @return
	 * @author RenYang
	 */
	List<BuildingUnion> selectBuildingUnionResult();
}
