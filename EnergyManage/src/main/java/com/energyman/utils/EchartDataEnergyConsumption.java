package com.energyman.utils;

import java.util.List;

public class EchartDataEnergyConsumption {
	//ÄÜºÄÍ³¼ÆÖù×´Í¼
	private List<String> xdata;//xÖá
    private List<Double>data;//yÖá
    
	public List<String> getXdata() {
		return xdata;
	}
	public void setXdata(List<String> xdata) {
		this.xdata = xdata;
	}
	public List<Double> getData() {
		return data;
	}
	public void setData(List<Double> data) {
		this.data = data;
	}
}
