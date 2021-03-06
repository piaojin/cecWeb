package com.piaojin.domain;

import com.google.gson.annotations.Expose;

/**
 * Task entity. @author MyEclipse Persistence Tools
 */

public class Task implements java.io.Serializable {

	// Fields

	@Expose
	private Integer tid;
	@Expose
	private Integer uid;
	@Expose
	private Integer eid;
	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	@Expose
	private Integer kid;
	public Integer getKid() {
		return kid;
	}

	public void setKid(Integer kid) {
		this.kid = kid;
	}

	private Employ employByUid;
	private Employ employByEid;
	@Expose
	private String time;
	@Expose
	private String title;
	@Expose
	private String starttime;
	@Expose
	private String endtime;
	@Expose
	private Integer status;
	@Expose
	private String content;

	// Constructors

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	/** default constructor */
	public Task() {
	}

	// Property accessors

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Employ getEmployByUid() {
		return this.employByUid;
	}

	public void setEmployByUid(Employ employByUid) {
		this.employByUid = employByUid;
	}

	public Employ getEmployByEid() {
		return this.employByEid;
	}

	public void setEmployByEid(Employ employByEid) {
		this.employByEid = employByEid;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getStarttime() {
		return this.starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return this.endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}