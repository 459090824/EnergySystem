package com.energyman.bean;

import java.util.Date;

public class AuthorityType {
	
	private Integer authorityType_ID;
	
	private String authorityType_Name;
	
	private String authorityType_Description;
	
	private Date create_Time;
	
	private Integer authorityType_Status;
	

	public Integer getAuthorityType_ID() {
		return authorityType_ID;
	}

	public void setAuthorityType_ID(Integer authorityType_ID) {
		this.authorityType_ID = authorityType_ID;
	}

	public String getAuthorityType_Name() {
		return authorityType_Name;
	}

	public void setAuthorityType_Name(String authorityType_Name) {
		this.authorityType_Name = authorityType_Name;
	}

	public String getAuthorityType_Description() {
		return authorityType_Description;
	}

	public void setAuthorityType_Description(String authorityType_Description) {
		this.authorityType_Description = authorityType_Description;
	}

	public Date getCreate_Time() {
		return create_Time;
	}

	public void setCreate_Time(Date create_Time) {
		this.create_Time = create_Time;
	}

	public Integer getAuthorityType_Status() {
		return authorityType_Status;
	}

	public void setAuthorityType_Status(Integer authorityType_Status) {
		this.authorityType_Status = authorityType_Status;
	}
}
