package com.energyman.bean;

public class EquipmentCountUnion {
	
	private Area area;
	
	private Building building;
	
	private Room room;
	
	private Addr addr;
	
	
	
	private String equipment_Name;
	
	private Integer equipment_ID;
	
	private Integer equipment_Code;
	
	private Integer equipmentType_ID;
	
	private Integer equipmentSubType_ID;
	
	private Integer equipmentControlModel_ID;
	
	private Integer state_ID;
	
	private String isAuto_Equipment;
	
	private Integer addr_ID;
	
	
	
	public String getEquipment_Name() {
		return equipment_Name;
	}

	public void setEquipment_Name(String equipment_Name) {
		this.equipment_Name = equipment_Name;
	}

	public Integer getEquipment_ID() {
		return equipment_ID;
	}

	public void setEquipment_ID(Integer equipment_ID) {
		this.equipment_ID = equipment_ID;
	}

	public Integer getEquipment_Code() {
		return equipment_Code;
	}

	public void setEquipment_Code(Integer equipment_Code) {
		this.equipment_Code = equipment_Code;
	}

	public Integer getEquipmentType_ID() {
		return equipmentType_ID;
	}

	public void setEquipmentType_ID(Integer equipmentType_ID) {
		this.equipmentType_ID = equipmentType_ID;
	}

	public Integer getEquipmentSubType_ID() {
		return equipmentSubType_ID;
	}

	public void setEquipmentSubType_ID(Integer equipmentSubType_ID) {
		this.equipmentSubType_ID = equipmentSubType_ID;
	}

	public Integer getEquipmentControlModel_ID() {
		return equipmentControlModel_ID;
	}

	public void setEquipmentControlModel_ID(Integer equipmentControlModel_ID) {
		this.equipmentControlModel_ID = equipmentControlModel_ID;
	}

	public Integer getState_ID() {
		return state_ID;
	}

	public void setState_ID(Integer state_ID) {
		this.state_ID = state_ID;
	}

	public String getIsAuto_Equipment() {
		return isAuto_Equipment;
	}

	public void setIsAuto_Equipment(String isAuto_Equipment) {
		this.isAuto_Equipment = isAuto_Equipment;
	}

	public Integer getAddr_ID() {
		return addr_ID;
	}

	public void setAddr_ID(Integer addr_ID) {
		this.addr_ID = addr_ID;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Addr getAddr() {
		return addr;
	}

	public void setAddr(Addr addr) {
		this.addr = addr;
	}

}
