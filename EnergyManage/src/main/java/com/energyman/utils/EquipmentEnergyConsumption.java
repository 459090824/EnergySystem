package com.energyman.utils;

public class EquipmentEnergyConsumption {

	//能耗统计-设备能耗列表
		private String equipment_Name;//设备名称
		private double energ_Consumption;//设备能耗
		private String equipment_Auto;//自动检测能耗
		public String getEquipment_Name() {
			return equipment_Name;
		}
		public void setEquipment_Name(String equipment_Name) {
			this.equipment_Name = equipment_Name;
		}
		public double getEnerg_Consumption() {
			return energ_Consumption;
		}
		public void setEnerg_Consumption(double energ_Consumption) {
			this.energ_Consumption = energ_Consumption;
		}
		public String getEquipment_Auto() {
			return equipment_Auto;
		}
		public void setEquipment_Auto(String equipment_Auto) {
			this.equipment_Auto = equipment_Auto;
		}
}
