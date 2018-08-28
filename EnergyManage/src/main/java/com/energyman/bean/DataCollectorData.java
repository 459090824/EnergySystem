package com.energyman.bean;

import java.util.Date;

public class DataCollectorData {
	private Integer collectonData_ID;
	
	private Integer collection_ID;
	
	private String content;
	
	private Integer energyType_ID;
	
	private Date collection_Time;

	public Integer getCollectonData_ID() {
		return collectonData_ID;
	}

	public void setCollectonData_ID(Integer collectonData_ID) {
		this.collectonData_ID = collectonData_ID;
	}

	public Integer getCollection_ID() {
		return collection_ID;
	}

	public void setCollection_ID(Integer collection_ID) {
		this.collection_ID = collection_ID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getEnergyType_ID() {
		return energyType_ID;
	}

	public void setEnergyType_ID(Integer energyType_ID) {
		this.energyType_ID = energyType_ID;
	}

	public Date getCollection_Time() {
		return collection_Time;
	}

	public void setCollection_Time(Date collection_Time) {
		this.collection_Time = collection_Time;
	}

	
	
	
}
