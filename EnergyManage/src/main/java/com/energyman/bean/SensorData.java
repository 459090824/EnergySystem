package com.energyman.bean;

import java.util.Date;

public class SensorData {
	private Integer sensorData_ID;
	
	private String content;
	
	private Date collection_Time;
	
	private Integer sensor_ID;

	public Integer getSensorData_ID() {
		return sensorData_ID;
	}

	public void setSensorData_ID(Integer sensorData_ID) {
		this.sensorData_ID = sensorData_ID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCollection_Time() {
		return collection_Time;
	}

	public void setCollection_Time(Date collection_Time) {
		this.collection_Time = collection_Time;
	}

	public Integer getSensor_ID() {
		return sensor_ID;
	}

	public void setSensor_ID(Integer sensor_ID) {
		this.sensor_ID = sensor_ID;
	}

	
	
	
}
