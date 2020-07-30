package com.lti.mod.searchservice.dto;

import java.math.BigDecimal;

public class TrainingEnrollmentDTO {
	private String userName;
	private Integer courseId;
	private BigDecimal ratings;
	private String approvalStatus;
	private Integer version;
	
	
	
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public BigDecimal getRatings() {
		return ratings;
	}
	public void setRatings(BigDecimal ratings) {
		this.ratings = ratings;
	}
	@Override
	public String toString() {
		return "TrainingEnrollmentDTO [userName=" + userName + ", courseId=" + courseId + ", ratings=" + ratings
				+ ", approvalStatus=" + approvalStatus + "]";
	}
	
	
	
	
	
	

}


