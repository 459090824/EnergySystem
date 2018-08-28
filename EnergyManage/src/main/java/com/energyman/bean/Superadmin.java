package com.energyman.bean;

import java.util.Date;

public class Superadmin {
    private Integer superadminid;

    private String username;

    private String name;

    private Short gender;

    private String address;

    private String telephone;

    private Date birthday;

    private Integer userstatus;

    private String email;

    private String password;

    private String littleheadportrait;

    private Integer bigheadportrait;

    public Integer getSuperadminid() {
        return superadminid;
    }

    public void setSuperadminid(Integer superadminid) {
        this.superadminid = superadminid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getLittleheadportrait() {
        return littleheadportrait;
    }

    public void setLittleheadportrait(String littleheadportrait) {
        this.littleheadportrait = littleheadportrait == null ? null : littleheadportrait.trim();
    }

    public Integer getBigheadportrait() {
        return bigheadportrait;
    }

    public void setBigheadportrait(Integer bigheadportrait) {
        this.bigheadportrait = bigheadportrait;
    }
}