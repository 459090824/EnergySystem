package com.energyman.bean;

public class AdminAuthorityUnion {
	
	private Integer noteid;

    private Integer authorityid;

    private Integer systemadminid;
    
    private Authority authority;

	public Integer getNoteid() {
		return noteid;
	}

	public void setNoteid(Integer noteid) {
		this.noteid = noteid;
	}

	public Integer getAuthorityid() {
		return authorityid;
	}

	public void setAuthorityid(Integer authorityid) {
		this.authorityid = authorityid;
	}

	public Integer getSystemadminid() {
		return systemadminid;
	}

	public void setSystemadminid(Integer systemadminid) {
		this.systemadminid = systemadminid;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}
    
    
}
