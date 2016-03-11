package com.zealot.service;

import java.util.List;

import com.zealot.common.Page;
import com.zealot.entity.InterceptRecord;
import com.zealot.common.exception.UserBusinessException;

public interface InterceptRecordService {
	/**
	 * 添加拦截记录
	 * @param interceptRecord
	 * @throws UserBusinessException
	 */
	public void saveInterceptRecord(InterceptRecord interceptRecord) throws UserBusinessException;
	
	/**
	 * 修改拦截记录
	 * @param interceptRecord
	 * @throws UserBusinessException
	 */
	public void updateInterceptRecord(InterceptRecord interceptRecord) throws UserBusinessException;
	
	/**
	 * 删除拦截记录
	 * @param interceptRecord
	 * @throws UserBusinessException
	 */
	public void deleteInterceptRecord(List<InterceptRecord> interceptRecord) throws UserBusinessException;
	
	/**
	 * 分页查询拦截记录
	 * @param param
	 * @param p
	 * @return
	 * @throws UserBusinessException
	 */
	public List<InterceptRecord> queryInterceptRecordPage(InterceptRecord param,Page p) throws UserBusinessException;
	
	/**
	 * 条件查询拦截记录
	 * @param param
	 * @return
	 * @throws UserBusinessException
	 */
	public List<InterceptRecord> queryInterceptRecord(InterceptRecord param) throws UserBusinessException;
	/**
	 * 根据主键获取拦截记录
	 * @param interceptRecordId 主键
	 * @return
	 * @throws UserBusinessException
	 */
	public InterceptRecord queryInterceptRecord(String interceptRecordId) throws UserBusinessException;
}
