package com.piaojin.domain;

import com.google.gson.annotations.Expose;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */

public class Message implements java.io.Serializable {

	// Fields

	@Expose
	private Integer mid;
	public Integer getReceiverid() {
		return receiverid;
	}

	public void setReceiverid(Integer receiverid) {
		this.receiverid = receiverid;
	}

	public Integer getSenderid() {
		return senderid;
	}

	public void setSenderid(Integer senderid) {
		this.senderid = senderid;
	}

	@Expose
	private Integer receiverid;
	@Expose
	private Integer senderid;
	@Expose
	private Integer kid;
	public Integer getKid() {
		return kid;
	}

	public void setKid(Integer kid) {
		this.kid = kid;
	}

	private Employ employByReceiverid;
	private Employ employBySenderid;
	@Expose
	private String sendtime;
	@Expose
	private String receivetime;
	@Expose
	private Integer type;
	@Expose
	private String msg;
	@Expose
	private String photourl;
	@Expose
	private String videourl;
	@Expose
	private String receiverip;
	public String getReceiverip() {
		return receiverip;
	}

	public void setReceiverip(String receiverip) {
		this.receiverip = receiverip;
	}

	@Expose
	private Integer status;

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** minimal constructor */
	public Message(Employ employByReceiverid, Employ employBySenderid,
			String sendtime, String receivetime, Integer type, Integer status) {
		this.employByReceiverid = employByReceiverid;
		this.employBySenderid = employBySenderid;
		this.sendtime = sendtime;
		this.receivetime = receivetime;
		this.type = type;
		this.status = status;
	}

	/** full constructor */
	public Message(Employ employByReceiverid, Employ employBySenderid,
			String sendtime, String receivetime, Integer type, String msg,
			String photourl, String videourl, Integer status) {
		this.employByReceiverid = employByReceiverid;
		this.employBySenderid = employBySenderid;
		this.sendtime = sendtime;
		this.receivetime = receivetime;
		this.type = type;
		this.msg = msg;
		this.photourl = photourl;
		this.videourl = videourl;
		this.status = status;
	}

	// Property accessors

	public Integer getMid() {
		return this.mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public Employ getEmployByReceiverid() {
		return this.employByReceiverid;
	}

	public void setEmployByReceiverid(Employ employByReceiverid) {
		this.employByReceiverid = employByReceiverid;
	}

	public Employ getEmployBySenderid() {
		return this.employBySenderid;
	}

	public void setEmployBySenderid(Employ employBySenderid) {
		this.employBySenderid = employBySenderid;
	}

	public String getSendtime() {
		return this.sendtime;
	}

	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}

	public String getReceivetime() {
		return this.receivetime;
	}

	public void setReceivetime(String receivetime) {
		this.receivetime = receivetime;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getPhotourl() {
		return this.photourl;
	}

	public void setPhotourl(String photourl) {
		this.photourl = photourl;
	}

	public String getVideourl() {
		return this.videourl;
	}

	public void setVideourl(String videourl) {
		this.videourl = videourl;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}