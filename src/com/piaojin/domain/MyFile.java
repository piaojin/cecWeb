package com.piaojin.domain;

import com.google.gson.annotations.Expose;

/**
 * File entity. @author MyEclipse Persistence Tools
 */

public class MyFile implements java.io.Serializable {

	// Fields

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	@Expose
	private Integer fid;
	@Expose
	private Integer uid;
	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	private Employ employ;
	@Expose
	private Integer type;
	@Expose
	private String url;
	@Expose
	private String httpurl;
	@Expose
	private Integer status;
	@Expose
	private String describes;
	@Expose
	private String absoluteurl;
	@Expose
	private String completedate;
	@Expose
	private String name;
	@Expose
	private String uname;
	@Expose
	private Double filesize;
	@Expose
	private Double completedsize;
	@Expose
	private Integer iscomplete;
	
	// Constructors

	public String getAbsoluteurl() {
		return absoluteurl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAbsoluteurl(String absoluteurl) {
		this.absoluteurl = absoluteurl;
	}

	public String getCompletedate() {
		return completedate;
	}

	public void setCompletedate(String completedate) {
		this.completedate = completedate;
	}


	public Double getFilesize() {
		return filesize;
	}

	public void setFilesize(Double filesize) {
		this.filesize = filesize;
	}

	public Double getCompletedsize() {
		return completedsize;
	}

	public void setCompletedsize(Double completedsize) {
		this.completedsize = completedsize;
	}

	public Integer getIscomplete() {
		return iscomplete;
	}

	public void setIscomplete(Integer iscomplete) {
		this.iscomplete = iscomplete;
	}

	/** default constructor */
	public MyFile() {
	}



	// Property accessors

	public Integer getFid() {
		return this.fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public Employ getEmploy() {
		return this.employ;
	}

	public void setEmploy(Employ employ) {
		this.employ = employ;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHttpurl() {
		return this.httpurl;
	}

	public void setHttpurl(String httpurl) {
		this.httpurl = httpurl;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDescribes() {
		return this.describes;
	}

	public void setDescribes(String describes) {
		this.describes = describes;
	}

}