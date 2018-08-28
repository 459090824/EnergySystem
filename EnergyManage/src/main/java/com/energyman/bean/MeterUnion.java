package com.energyman.bean;

import javax.management.loading.PrivateClassLoader;

public class MeterUnion {
	
	private String meter_Name;
	
	private Integer meter_ID;
	
	private Integer meter_Code;
	
	private Integer meterType_ID;
	
	private Integer state_ID;
	
	private Integer collection_ID;
	
	private Integer addr_ID;
	
	private Integer systemEquipmentType_ID;
	
	private SystemEquipmentType systemEquipmentType;
	
	private SystemEquipmentSubType systemEquipmentSubType;
	
	private State state;
	
	private Addr addr;
	
	private DataCollector dataCollector;
	
	private Room room;

	public Integer getSystemEquipmentType_ID() {
		return systemEquipmentType_ID;
	}

	public void setSystemEquipmentType_ID(Integer systemEquipmentType_ID) {
		this.systemEquipmentType_ID = systemEquipmentType_ID;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getMeter_Name() {
		return meter_Name;
	}

	public void setMeter_Name(String meter_Name) {
		this.meter_Name = meter_Name;
	}

	public Integer getMeter_ID() {
		return meter_ID;
	}

	public void setMeter_ID(Integer meter_ID) {
		this.meter_ID = meter_ID;
	}

	public Integer getMeter_Code() {
		return meter_Code;
	}

	public void setMeter_Code(Integer meter_Code) {
		this.meter_Code = meter_Code;
	}

	public Integer getMeterType_ID() {
		return meterType_ID;
	}

	public void setMeterType_ID(Integer meterType_ID) {
		this.meterType_ID = meterType_ID;
	}

	public Integer getState_ID() {
		return state_ID;
	}

	public void setState_ID(Integer state_ID) {
		this.state_ID = state_ID;
	}

	public Integer getCollection_ID() {
		return collection_ID;
	}

	public void setCollection_ID(Integer collection_ID) {
		this.collection_ID = collection_ID;
	}

	public Integer getAddr_ID() {
		return addr_ID;
	}

	public void setAddr_ID(Integer addr_ID) {
		this.addr_ID = addr_ID;
	}


	public SystemEquipmentType getSystemEquipmentType() {
		return systemEquipmentType;
	}

	public void setSystemEquipmentType(SystemEquipmentType systemEquipmentType) {
		this.systemEquipmentType = systemEquipmentType;
	}
	
	public SystemEquipmentSubType getSystemEquipmentSubType() {
		return systemEquipmentSubType;
	}

	public void setSystemEquipmentSubType(SystemEquipmentSubType systemEquipmentSubType) {
		this.systemEquipmentSubType = systemEquipmentSubType;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Addr getAddr() {
		return addr;
	}

	public void setAddr(Addr addr) {
		this.addr = addr;
	}

	public DataCollector getDataCollector() {
		return dataCollector;
	}

	public void setDataCollector(DataCollector dataCollector) {
		this.dataCollector = dataCollector;
	}
	
}
