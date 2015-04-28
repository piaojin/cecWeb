package com.piaojin.domain;

import java.util.HashSet;
import java.util.Set;

import com.google.gson.annotations.Expose;

/**
 * Employ entity. @author MyEclipse Persistence Tools
 */

public class Employ implements java.io.Serializable {

	// Fields

	@Expose
	private Integer uid;
	@Expose
	private Integer kid;
	public Integer getKid() {
		return kid;
	}

	public void setKid(Integer kid) {
		this.kid = kid;
	}

	@Expose
	private String name;
	@Expose
	private Integer sex;
	@Expose
	private String tel;
	@Expose
	private String email;
	@Expose
	private String address;
	@Expose
	private Integer employeeid;
	@Expose
	private String pwd;
	@Expose
	private Integer dpid;
	@Expose
	private String head;
	@Expose
	private Integer level;
	public Integer getDpid() {
		return dpid;
	}

	public void setDpid(Integer dpid) {
		this.dpid = dpid;
	}

	private Set tasksForUid = new HashSet(0);
	private Set messagesForSenderid = new HashSet(0);
	private Set schedules = new HashSet(0);
	private Set files = new HashSet(0);
	private Set tasksForEid = new HashSet(0);
	private Set messagesForReceiverid = new HashSet(0);

	// Constructors

	/** default constructor */
	public Employ() {
	}



	// Property accessors

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getEmployeeid() {
		return this.employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getHead() {
		return this.head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Set getTasksForUid() {
		return this.tasksForUid;
	}

	public void setTasksForUid(Set tasksForUid) {
		this.tasksForUid = tasksForUid;
	}

	public Set getMessagesForSenderid() {
		return this.messagesForSenderid;
	}

	public void setMessagesForSenderid(Set messagesForSenderid) {
		this.messagesForSenderid = messagesForSenderid;
	}

	public Set getSchedules() {
		return this.schedules;
	}

	public void setSchedules(Set schedules) {
		this.schedules = schedules;
	}

	public Set getFiles() {
		return this.files;
	}

	public void setFiles(Set files) {
		this.files = files;
	}

	public Set getTasksForEid() {
		return this.tasksForEid;
	}

	public void setTasksForEid(Set tasksForEid) {
		this.tasksForEid = tasksForEid;
	}

	public Set getMessagesForReceiverid() {
		return this.messagesForReceiverid;
	}

	public void setMessagesForReceiverid(Set messagesForReceiverid) {
		this.messagesForReceiverid = messagesForReceiverid;
	}

}