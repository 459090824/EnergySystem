package com.energyman.bean;


public class AddrUnion {
	
	private Integer addr_ID;
	
	private Integer addrType_ID;
	
	private Integer addr_Code;
	
	private Room room;
	
	private Park park;
	
	private Building building;
	
	private Area area;

	public Integer getAddr_ID() {
		return addr_ID;
	}

	public void setAddr_ID(Integer addr_ID) {
		this.addr_ID = addr_ID;
	}

	public Integer getAddrType_ID() {
		return addrType_ID;
	}

	public void setAddrType_ID(Integer addrType_ID) {
		this.addrType_ID = addrType_ID;
	}

	public Integer getAddr_Code() {
		return addr_Code;
	}

	public void setAddr_Code(Integer addr_Code) {
		this.addr_Code = addr_Code;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Park getPark() {
		return park;
	}

	public void setPark(Park park) {
		this.park = park;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
	
	
}
