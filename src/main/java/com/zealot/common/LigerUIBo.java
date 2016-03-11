package com.zealot.common;

import java.util.List;
@SuppressWarnings("rawtypes")
public class LigerUIBo implements java.io.Serializable{
  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List Rows;
	private String Total;
	
	public List getRows() {
		return Rows;
	}
	public void setRows(List rows) {
		Rows = rows;
	}
	public String getTotal() {
		return Total;
	}
	public void setTotal(String total) {
		Total = total;
	}

	
}
