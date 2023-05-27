package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="sendmail")
public class SendEmails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Long mailId;
	private String tos;
	private String ccs;
	private String subjects;
	private String texts;
	private String createdDate;
	private String email;
	
	public Long getMailId() {
		return mailId;
	}
	public void setMailId(Long mailId) {
		this.mailId = mailId;
	}
	public String getTos() {
		return tos;
	}
	public void setTos(String tos) {
		this.tos = tos;
	}
	public String getCcs() {
		return ccs;
	}
	public void setCcs(String ccs) {
		this.ccs = ccs;
	}
	public String getSubjects() {
		return subjects;
	}
	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}
	public String getTexts() {
		return texts;
	}
	public void setTexts(String texts) {
		this.texts = texts;
	}
	public Object getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

	
	

}
