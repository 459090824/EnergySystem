package com.energyman.dao;

import java.util.List;

import com.energyman.bean.SensorUnion;

public interface SensorUnionMapper {

	
	/**���ϲ�ѯ��ô�����������Ϣ��ɾ�����豸���⣩
	 * @return
	 * @author RenYang
	 */
	List<SensorUnion> selectSensorUnionResult(Integer state_ID);
}
