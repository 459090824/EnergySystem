package com.energyman.dao;

import java.util.List;

import com.energyman.bean.DataCollectorUnion;

public interface DataCollectorUnionDao {

	/**���ϲ�ѯ����豸������Ϣ(ɾ���ĳ���)
	 * @return
	 * @author RenYang
	 */
	List<DataCollectorUnion> selectDataCollectorUnionResult(Integer state_ID);
}
