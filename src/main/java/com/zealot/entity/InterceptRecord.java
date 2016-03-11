package com.zealot.entity;

import com.zealot.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class InterceptRecord extends BaseEntity{
	private static final long serialVersionUID = -3027086906504961137L;
	
	@Id
	@GeneratedValue
	private int id;
	
	/**
	 * 手机号码
	 */
	@Column(name = "phone")
	private String phone;
	
	/**
	 * 拦截号码
	 */
	@Column(name = "interceptNumber")
	private String interceptNumber;
	
	/**
	 * 拦截内容
	 */
	@Column(name = "interceptContent")
	private String interceptContent;
	
	/**
	 * 拦截时间
	 */
	@Column(name="interceptTime")
	private String interceptTime;

	//查询参数
	private String startTime;
	
	private String endTime;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getInterceptNumber() {
		return interceptNumber;
	}

	public void setInterceptNumber(String interceptNumber) {
		this.interceptNumber = interceptNumber;
	}

	public String getInterceptContent() {
		return interceptContent;
	}

	public void setInterceptContent(String interceptContent) {
		this.interceptContent = interceptContent;
	}

	public String getInterceptTime() {
		return interceptTime;
	}

	public void setInterceptTime(String interceptTime) {
		this.interceptTime = interceptTime;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
