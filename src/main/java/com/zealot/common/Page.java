/*
 * @(#)ObjectUtil.java        1.0 2009-8-11
 *
 * Copyright (c) 2007-2009 Kuangxf, Co., Ltd.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of 
 * Kuangxf
 * You shall not disclose such Confidential Information and shall use 
 * it only in accordance with the terms of the license agreement you 
 * entered Integero with Kuangxf.
 */

package com.zealot.common;



public final class Page {

	private Integer page = 1;
	private Integer pagesize = 20;
	private Integer preRow = 0;
	private Integer totalRecord = 0;
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPagesize() {
		return pagesize;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	public Integer getPreRow() {
		return preRow;
	}
	public void setPreRow(Integer preRow) {
		this.preRow = preRow;
	}
	public Integer getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}
	
}
