package com.energyman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyman.bean.EquipmentUnion;
import com.energyman.dao.EquipmentUnionMapper;
import com.energyman.service.IEquipmentUnionService;

@Service
public class EquipmentUnionService implements IEquipmentUnionService{
	
	@Autowired
	EquipmentUnionMapper equipmentUnionMapper;
	
	@Override
	public List<EquipmentUnion> findAllEquipmentUnion(Integer state_ID) {
		// TODO Auto-generated method stub
		return equipmentUnionMapper.selectEquipmentUnionResult(state_ID);
	}

	@Override
	public boolean setEquipmentModel(EquipmentUnion equipmentUnion) {
		// TODO Auto-generated method stub
		int result=equipmentUnionMapper.updateEquipmentHMModel(equipmentUnion);
		if(result > 0){
			return true;
		}else{
			return false;
		}		
	}

	@Override
	public List<EquipmentUnion> findAllDispatchEquipment(EquipmentUnion equipmentUnion) {
		// TODO Auto-generated method stub
		return equipmentUnionMapper.selectDispatchEquipment(equipmentUnion);
	}

	@Override
	public int findNumByAddr(Integer addr_Code) {
		// TODO Auto-generated method stub
		return equipmentUnionMapper.selectNumByAddr(addr_Code);
	}

	@Override
	public EquipmentUnion findEquipmentByCode(Integer equipment_Code) {
		// TODO Auto-generated method stub
		return equipmentUnionMapper.selectEquipmentByCode(equipment_Code);
	}

	@Override
	public List<EquipmentUnion> findEquipmentByModel(Integer equipmentControlModel_ID) {
		// TODO Auto-generated method stub
		return equipmentUnionMapper.selectEquipmentByModel(equipmentControlModel_ID);
	}

}
