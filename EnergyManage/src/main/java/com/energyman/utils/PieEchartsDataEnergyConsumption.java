package com.energyman.utils;

import java.util.List;

public class PieEchartsDataEnergyConsumption {
	
	//能量消耗统计饼状图
		private List<String> category;
		private List<Double> data;
		
		public List<String> getCategory() {
			return category;
		}
		public void setCategory(List<String> category) {
			this.category = category;
		}
		public List<Double> getData() {
			return data;
		}
		public void setData(List<Double> data) {
			this.data = data;
		}
}	
