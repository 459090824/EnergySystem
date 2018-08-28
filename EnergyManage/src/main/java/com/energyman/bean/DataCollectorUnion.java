package com.energyman.bean;


public class DataCollectorUnion {
	
	private String collection_Name;
	
	private Integer collection_ID;
	
	private Integer collection_Code;
	
	private Integer collectionType_ID;
	
	private Integer state_ID;
	
	private String collect_Interval;
	
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

	public String getCollection_Name() {
		return collection_Name;
	}

	public void setCollection_Name(String collection_Name) {
		this.collection_Name = collection_Name;
	}

	public Integer getCollection_ID() {
		return collection_ID;
	}

	public void setCollection_ID(Integer collection_ID) {
		this.collection_ID = collection_ID;
	}

	public Integer getCollection_Code() {
		return collection_Code;
	}

	public void setCollection_Code(Integer collection_Code) {
		this.collection_Code = collection_Code;
	}

	public Integer getCollectionType_ID() {
		return collectionType_ID;
	}

	public void setCollectionType_ID(Integer collectionType_ID) {
		this.collectionType_ID = collectionType_ID;
	}

	public Integer getState_ID() {
		return state_ID;
	}

	public void setState_ID(Integer state_ID) {
		this.state_ID = state_ID;
	}

	public String getCollect_Interval() {
		return collect_Interval;
	}

	public void setCollect_Interval(String collect_Interval) {
		this.collect_Interval = collect_Interval;
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
