package com.energyman.bean;

import java.util.Date;

public class Admin {
    private Integer systemadminid;

    private String username;

    private String password;

    private Short gender;

	private String email;

    private String telephone;

    private String address;

    private Date birthday;

    private Integer userstatus;

    private String littleheadportrait;

    private String bigheadportrait;

    public Integer getSystemadminid() {
        return systemadminid;
    }

    public void setSystemadminid(Integer systemadminid) {
        this.systemadminid = systemadminid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(Integer userstatus) {
        this.userstatus = userstatus;
    }

    public String getLittleheadportrait() {
        return littleheadportrait;
    }

    public void setLittleheadportrait(String littleheadportrait) {
        this.littleheadportrait = littleheadportrait == null ? null : littleheadportrait.trim();
    }

    public String getBigheadportrait() {
        return bigheadportrait;
    }

    public void setBigheadportrait(String bigheadportrait) {
        this.bigheadportrait = bigheadportrait;
    }
    
    public Short getGender() {
		return gender;
	}

	public void setGender(Short gender) {
		this.gender = gender;
	}
}