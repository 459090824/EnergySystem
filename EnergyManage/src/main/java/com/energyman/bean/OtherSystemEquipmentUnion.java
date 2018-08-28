package com.energyman.bean;

public class OtherSystemEquipmentUnion {
	
	private Integer systemEquipmentID;
	
	private String systemEquipmentName;
	
	private Integer systemEquipmentCode;
	
	private Integer systemEquipmentTypeID;
	
	private Integer stateID;
	
	private Integer addrID;
	
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

	public Integer getSystemEquipmentID() {
		return systemEquipmentID;
	}

	public void setSystemEquipmentID(Integer systemEquipmentID) {
		this.systemEquipmentID = systemEquipmentID;
	}

	public String getSystemEquipmentName() {
		return systemEquipmentName;
	}

	public void setSystemEquipmentName(String systemEquipmentName) {
		this.systemEquipmentName = systemEquipmentName;
	}

	public Integer getSystemEquipmentCode() {
		return systemEquipmentCode;
	}

	public void setSystemEquipmentCode(Integer systemEquipmentCode) {
		this.systemEquipmentCode = systemEquipmentCode;
	}

	public Integer getSystemEquipmentTypeID() {
		return systemEquipmentTypeID;
	}

	public void setSystemEquipmentTypeID(Integer systemEquipmentTypeID) {
		this.systemEquipmentTypeID = systemEquipmentTypeID;
	}

	public Integer getStateID() {
		return stateID;
	}

	public void setStateID(Integer stateID) {
		this.stateID = stateID;
	}

	public Integer getAddrID() {
		return addrID;
	}

	public void setAddrID(Integer addrID) {
		this.addrID = addrID;
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

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
}	
