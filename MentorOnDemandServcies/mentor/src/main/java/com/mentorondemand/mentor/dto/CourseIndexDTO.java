package com.mentorondemand.mentor.dto;

import java.math.BigDecimal;
import java.util.List;



public class CourseIndexDTO {
	private String couseId;
	private Long documentVersion;
	private String courseName;
	private Integer skillId;
	private Integer batchId;
	private BigDecimal studentFee;
	private BigDecimal mentorShare;
	private String batchName;
	private String skillName;
	private String mentorName;
	private String courseImage;
	private BigDecimal mentorFee;
	private String userName;
	private BigDecimal courseRating;
	private List<StudentTrainingDTO> trainees;
	
	
	public BigDecimal getCourseRating() {
		return courseRating;
	}
	public void setCourseRating(BigDecimal courseRating) {
		this.courseRating = courseRating;
	}
	public String getMentorName() {
		return mentorName;
	}
	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}
	
	public String getCourseImage() {
		return courseImage;
	}
	public void setCourseImage(String courseImage) {
		this.courseImage = courseImage;
	}
	public List<StudentTrainingDTO> getTrainees() {
		return trainees;
	}
	public void setTrainees(List<StudentTrainingDTO> trainees) {
		this.trainees = trainees;
	}
	public String getCouseId() {
		return couseId;
	}
	public void setCouseId(String couseId) {
		this.couseId = couseId;
	}
	public Long getDocumentVersion() {
		return documentVersion;
	}
	public void setDocumentVersion(Long documentVersion) {
		this.documentVersion = documentVersion;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Integer getSkillId() {
		return skillId;
	}
	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}
	public Integer getBatchId() {
		return batchId;
	}
	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}
	public BigDecimal getStudentFee() {
		return studentFee;
	}
	public void setStudentFee(BigDecimal studentFee) {
		this.studentFee = studentFee;
	}
	public BigDecimal getMentorShare() {
		return mentorShare;
	}
	public void setMentorShare(BigDecimal mentorShare) {
		this.mentorShare = mentorShare;
	}
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	
	public BigDecimal getMentorFee() {
		return mentorFee;
	}
	public void setMentorFee(BigDecimal mentorFee) {
		this.mentorFee = mentorFee;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "CourseIndexDTO [couseId=" + couseId + ", documentVersion=" + documentVersion + ", courseName="
				+ courseName + ", skillId=" + skillId + ", batchId=" + batchId + ", studentFee=" + studentFee
				+ ", mentorShare=" + mentorShare + ", batchName=" + batchName + ", skillName=" + skillName
				+ ", mentorName=" + mentorName + ", courseImage=" + courseImage + ", mentorFee=" + mentorFee
				+ ", userName=" + userName + ", trainees=" + trainees + "]";
	}
	
	
}
