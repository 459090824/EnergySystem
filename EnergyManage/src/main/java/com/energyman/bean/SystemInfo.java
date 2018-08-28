package com.energyman.bean;

import java.util.Date;

public class SystemInfo {
	
	private Integer inforID;
	
	private String inforContent;
	
	private Date inforTime;
	
	private Integer processState;

	public Integer getInforID() {
		return inforID;
	}

	public void setInforID(Integer inforID) {
		this.inforID = inforID;
	}

	public String getInforContent() {
		return inforContent;
	}

	public void setInforContent(String inforContent) {
		this.inforContent = inforContent;
	}

	public Date getInforTime() {
		return inforTime;
	}

	public void setInforTime(Date inforTime) {
		this.inforTime = inforTime;
	}

	public Integer getProcessState() {
		return processState;
	}

	public void setProcessState(Integer processState) {
		this.processState = processState;
	}
	
}
