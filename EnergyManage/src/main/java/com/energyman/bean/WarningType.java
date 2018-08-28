package com.energyman.bean;

public class WarningType {
    private Integer warningtypeid;

    private String warningtypename;

    private String warningtypedesc;
    
    private Integer typestate;
    
    public Integer getTypestate() {
		return typestate;
	}

	public void setTypestate(Integer typestate) {
		this.typestate = typestate;
	}

	public Integer getWarningtypeid() {
        return warningtypeid;
    }

    public void setWarningtypeid(Integer warningtypeid) {
        this.warningtypeid = warningtypeid;
    }

    public String getWarningtypename() {
        return warningtypename;
    }

    public void setWarningtypename(String warningtypename) {
        this.warningtypename = warningtypename == null ? null : warningtypename.trim();
    }

    public String getWarningtypedesc() {
        return warningtypedesc;
    }

    public void setWarningtypedesc(String warningtypedesc) {
        this.warningtypedesc = warningtypedesc == null ? null : warningtypedesc.trim();
    }
}