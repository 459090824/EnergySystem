package com.energyman.bean;

import java.util.Date;

public class Authority {
    private Integer authorityid;
    
    private Integer adminfunctionid;
    
    private Integer authoritytypeid;

    private String authorityname;

    private String authoritydescription;

    private Integer authoritystatus;

    private Date authoritytime;

    private Integer authoritycreator;
    
    private boolean adminAuthority;
       
    public boolean isAdminAuthority() {
		return adminAuthority;
	}

	public void setAdminAuthority(boolean adminAuthority) {
		this.adminAuthority = adminAuthority;
	}

	public Integer getAdminfunctionid() {
		return adminfunctionid;
	}

	public void setAdminfunctionid(Integer adminfunctionid) {
		this.adminfunctionid = adminfunctionid;
	}

	public Integer getAuthoritytypeid() {
		return authoritytypeid;
	}

	public void setAuthoritytypeid(Integer authoritytypeid) {
		this.authoritytypeid = authoritytypeid;
	}

	public Integer getAuthorityid() {
        return authorityid;
    }

    public void setAuthorityid(Integer authorityid) {
        this.authorityid = authorityid;
    }

    public String getAuthorityname() {
        return authorityname;
    }

    public void setAuthorityname(String authorityname) {
        this.authorityname = authorityname == null ? null : authorityname.trim();
    }

    public String getAuthoritydescription() {
        return authoritydescription;
    }

    public void setAuthoritydescription(String authoritydescription) {
        this.authoritydescription = authoritydescription == null ? null : authoritydescription.trim();
    }

    public Integer getAuthoritystatus() {
        return authoritystatus;
    }

    public void setAuthoritystatus(Integer authoritystatus) {
        this.authoritystatus = authoritystatus;
    }

    public Date getAuthoritytime() {
        return authoritytime;
    }

    public void setAuthoritytime(Date authoritytime) {
        this.authoritytime = authoritytime;
    }

    public Integer getAuthoritycreator() {
        return authoritycreator;
    }

    public void setAuthoritycreator(Integer authoritycreator) {
        this.authoritycreator = authoritycreator;
    }
}