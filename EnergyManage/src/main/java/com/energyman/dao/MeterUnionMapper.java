package com.energyman.dao;

import java.util.List;

import com.energyman.bean.MeterUnion;

public interface MeterUnionMapper {

	/**�����ѯ�õ�����������Ϣ(ɾ���ĳ���)
	 * @return
	 * @author RenYang
	 */
	List<MeterUnion> selectMeterUnionResult(Integer state_ID);
}
