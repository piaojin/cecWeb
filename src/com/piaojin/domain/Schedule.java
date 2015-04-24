package com.piaojin.domain;

import com.google.gson.annotations.Expose;

/**
 * Schedule entity. @author MyEclipse Persistence Tools
 */

public class Schedule implements java.io.Serializable {

	// Fields

	@Expose
	private Integer sid;
	@Expose
	private Employ employ;
	@Expose
	private String title;
	@Expose
	private String content;
	@Expose
	private String time;
	@Expose
	private String remindtime;
	@Expose
	private Integer status;
	@Expose
	private Integer isremind;
	@Expose
	private String endtime;

	// Constructors

	/** default constructor */
	public Schedule() {
	}

	// Property accessors

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Employ getEmploy() {
		return this.employ;
	}

	public void setEmploy(Employ employ) {
		this.employ = employ;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getRemindtime() {
		return this.remindtime;
	}

	public void setRemindtime(String remindtime) {
		this.remindtime = remindtime;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsremind() {
		return this.isremind;
	}

	public void setIsremind(Integer isremind) {
		this.isremind = isremind;
	}

	public String getEndtime() {
		return this.endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

}