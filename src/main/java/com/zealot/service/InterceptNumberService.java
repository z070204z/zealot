package com.zealot.service;

import java.util.List;

import com.zealot.common.Page;
import com.zealot.entity.InterceptNumber;
import com.zealot.common.exception.UserBusinessException;

public interface InterceptNumberService {
	/**
	 * 添加拦截号码
	 * @param interceptNumber
	 * @throws UserBusinessException
	 */
	public void saveInterceptNumber(InterceptNumber interceptNumber) throws UserBusinessException;
	
	/**
	 * 修改拦截号码
	 * @param interceptNumber
	 * @throws UserBusinessException
	 */
	public void updateInterceptNumber(InterceptNumber interceptNumber) throws UserBusinessException;
	
	/**
	 * 删除拦截号码
	 * @param interceptNumber
	 * @throws UserBusinessException
	 */
	public void deleteInterceptNumber(List<InterceptNumber> interceptNumber) throws UserBusinessException;
	
	/**
	 * 分页查询拦截号码
	 * @param param
	 * @param p
	 * @return
	 * @throws UserBusinessException
	 */
	public List<InterceptNumber> queryInterceptNumberPage(InterceptNumber param,Page p) throws UserBusinessException;
	
	/**
	 * 条件查询拦截号码
	 * @param param
	 * @return
	 * @throws UserBusinessException
	 */
	public List<InterceptNumber> queryInterceptNumber(InterceptNumber param) throws UserBusinessException;
	/**
	 * 根据主键获取拦截号码
	 * @param interceptNumberId 主键
	 * @return
	 * @throws UserBusinessException
	 */
	public InterceptNumber queryInterceptNumber(String interceptNumberId) throws UserBusinessException;
}
