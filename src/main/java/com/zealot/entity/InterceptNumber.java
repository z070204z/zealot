package com.zealot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.zealot.common.BaseEntity;


@Entity
public class InterceptNumber extends BaseEntity{
	private static final long serialVersionUID = -8078253320915709165L;

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "number")
	private String number;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
}
