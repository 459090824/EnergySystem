package com.energyman.bean;

import java.util.Date;

public class WarningUnion {
	
	 	private Integer warningid;

	    private String warningcontent;

	    private Date warningtime;

	    private Integer processstate;

	    private Integer warningtypeid;
	    
	    private Integer warninglevel;
	    
		private WarningType warningType;

		public Integer getWarningid() {
			return warningid;
		}

		public void setWarningid(Integer warningid) {
			this.warningid = warningid;
		}

		public String getWarningcontent() {
			return warningcontent;
		}

		public void setWarningcontent(String warningcontent) {
			this.warningcontent = warningcontent;
		}

		public Date getWarningtime() {
			return warningtime;
		}

		public void setWarningtime(Date warningtime) {
			this.warningtime = warningtime;
		}

		public Integer getProcessstate() {
			return processstate;
		}

		public void setProcessstate(Integer processstate) {
			this.processstate = processstate;
		}

		public Integer getWarningtypeid() {
			return warningtypeid;
		}

		public void setWarningtypeid(Integer warningtypeid) {
			this.warningtypeid = warningtypeid;
		}
		
		public Integer getWarninglevel() {
			return warninglevel;
		}

		public void setWarninglevel(Integer warninglevel) {
			this.warninglevel = warninglevel;
		}
		
		public WarningType getWarningType() {
			return warningType;
		}

		public void setWarningType(WarningType warningType) {
			this.warningType = warningType;
		}
	    

}
