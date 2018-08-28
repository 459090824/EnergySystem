package com.energyman.bean;


public class SensorUnion {
	
	private String sensor_Name;
	
	private Integer sensor_ID;
	
	private Integer sensor_Code;
	
	private Integer sensorType_ID;
	
	private Integer state_ID;
	
	private String sensor_Interval;
	
	private Integer addr_ID;
	
	private Integer systemEquipmentType_ID;
	
	private SystemEquipmentType systemEquipmentType;
	
	private SystemEquipmentSubType systemEquipmentSubType;
	
	private Addr addr;
	
	private State state;
	
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

	public String getSensor_Name() {
		return sensor_Name;
	}

	public void setSensor_Name(String sensor_Name) {
		this.sensor_Name = sensor_Name;
	}

	public Integer getSensor_ID() {
		return sensor_ID;
	}

	public void setSensor_ID(Integer sensor_ID) {
		this.sensor_ID = sensor_ID;
	}

	public Integer getSensor_Code() {
		return sensor_Code;
	}

	public void setSensor_Code(Integer sensor_Code) {
		this.sensor_Code = sensor_Code;
	}

	public Integer getSensorType_ID() {
		return sensorType_ID;
	}

	public void setSensorType_ID(Integer sensorType_ID) {
		this.sensorType_ID = sensorType_ID;
	}

	public Integer getState_ID() {
		return state_ID;
	}

	public void setState_ID(Integer state_ID) {
		this.state_ID = state_ID;
	}

	public String getSensor_Interval() {
		return sensor_Interval;
	}

	public void setSensor_Interval(String sensor_Interval) {
		this.sensor_Interval = sensor_Interval;
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

	public Addr getAddr() {
		return addr;
	}

	public void setAddr(Addr addr) {
		this.addr = addr;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
		
}
