package com.energyman.utils;

import java.util.List;

public class EchartDataEnergyConsumption {
	//�ܺ�ͳ����״ͼ
	private List<String> xdata;//x��
    private List<Double>data;//y��
    
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
