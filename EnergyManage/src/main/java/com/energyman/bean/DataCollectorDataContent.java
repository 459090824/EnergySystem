package com.energyman.bean;

public class DataCollectorDataContent {

	private Integer equipment_Code;
	
	private double current_data_meter;
	
	public Integer getEquipment_Code() {
		return equipment_Code;
	}

	public void setEquipment_Code(Integer equipment_Code) {
		this.equipment_Code = equipment_Code;
	}

	public double getCurrent_data_meter() {
		return current_data_meter;
	}

	public void setCurrent_data_meter(double current_data_meter) {
		this.current_data_meter = current_data_meter;
	}
	
	public String toString(){
		return "[equipment_Code="+equipment_Code+",current_data_meter:"+current_data_meter+"]";		
	}
}
