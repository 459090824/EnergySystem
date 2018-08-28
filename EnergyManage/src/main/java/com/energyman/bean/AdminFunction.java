package com.energyman.bean;

import java.util.Date;

public class AdminFunction {
	
	private Integer adminFunction_ID;
	
	private String function_Name;
	
	private Integer function_Location;
	
	private Integer function_Status;
	
	private String function_Path;
	
	private Integer parent_Function;
	
	private String function_Description;
	
	private Integer function_Level;
	
	private String iS_Menu;
	
	private Date create_Time;
	
	private String icon_Name;
	
	

	public String getIcon_Name() {
		return icon_Name;
	}

	public void setIcon_Name(String icon_Name) {
		this.icon_Name = icon_Name;
	}

	public Integer getAdminFunction_ID() {
		return adminFunction_ID;
	}

	public void setAdminFunction_ID(Integer adminFunction_ID) {
		this.adminFunction_ID = adminFunction_ID;
	}

	public String getFunction_Name() {
		return function_Name;
	}

	public void setFunction_Name(String function_Name) {
		this.function_Name = function_Name;
	}

	public Integer getFunction_Location() {
		return function_Location;
	}

	public void setFunction_Location(Integer function_Location) {
		this.function_Location = function_Location;
	}

	public Integer getFunction_Status() {
		return function_Status;
	}

	public void setFunction_Status(Integer function_Status) {
		this.function_Status = function_Status;
	}

	public String getFunction_Path() {
		return function_Path;
	}

	public void setFunction_Path(String function_Path) {
		this.function_Path = function_Path;
	}

	public Integer getParent_Function() {
		return parent_Function;
	}

	public void setParent_Function(Integer parent_Function) {
		this.parent_Function = parent_Function;
	}

	public String getFunction_Description() {
		return function_Description;
	}

	public void setFunction_Description(String function_Description) {
		this.function_Description = function_Description;
	}

	public Integer getFunction_Level() {
		return function_Level;
	}

	public void setFunction_Level(Integer function_Level) {
		this.function_Level = function_Level;
	}

	public String getiS_Menu() {
		return iS_Menu;
	}

	public void setiS_Menu(String iS_Menu) {
		this.iS_Menu = iS_Menu;
	}

	public Date getCreate_Time() {
		return create_Time;
	}

	public void setCreate_Time(Date create_Time) {
		this.create_Time = create_Time;
	}
	
	
	
}
