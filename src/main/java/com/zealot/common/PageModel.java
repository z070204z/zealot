package com.zealot.common;
public class PageModel extends BaseEntity{
	
	private static final long serialVersionUID = 2786101981519643837L;

	private static final int PAGE_SIZE = 10;
	
	/** ��ǰ��ҳ�� */
	private int pageIndex;
	/** һҳ��ʾ������ */
	private int pageSize;
	/** �ܼ�¼���� */
	private int recordCount;
	
	/** setter and getter method */
	public int getPageIndex() {
		return pageIndex < 1 ? 1 : this.pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize < 1 ? PAGE_SIZE : pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public int getTotalSize(){
		return this.getRecordCount() % this.getPageSize() == 0
					? this.getRecordCount() / this.getPageSize() 
					: (this.getRecordCount() / this.getPageSize()) + 1;
	}
	
	public int getPagetag() {
		double tag=recordCount/(double)pageSize;
		tag=Math.ceil(tag);
		return (int)tag;
	}
	/** ��ҳʱ��ȡ��ʼ������ */
	public int getStartRow() {
		// SELECT * FROM hrm_notice LIMIT 2,1 3-1 * 1: ÿһҳ��ʾ�ļ�¼����
		// 3 : ��ǰҳ�� pageIndex
		
		this.pageIndex = this.getPageIndex() > this.getTotalSize() ? this.getTotalSize() : this.getPageIndex();
		return (pageIndex - 1) * this.getPageSize();
	}
}
