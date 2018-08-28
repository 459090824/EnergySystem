package com.energyman.bean;

import java.util.Date;

public class EquipmentDispatch {
	private Integer dispatch_ID;
	
	private Integer equipment_ID;
	
	private Date start_Time;
	
	private Date end_Time;

	public Integer getDispatch_ID() {
		return dispatch_ID;
	}

	public void setDispatch_ID(Integer dispatch_ID) {
		this.dispatch_ID = dispatch_ID;
	}

	public Integer getEquipment_ID() {
		return equipment_ID;
	}

	public void setEquipment_ID(Integer equipment_ID) {
		this.equipment_ID = equipment_ID;
	}

	public Date getStart_Time() {
		return start_Time;
	}

	public void setStart_Time(Date start_Time) {
		this.start_Time = start_Time;
	}

	public Date getEnd_Time() {
		return end_Time;
	}

	public void setEnd_Time(Date end_Time) {
		this.end_Time = end_Time;
	}

	
	
	
}
