package com.zealot.service.impl;

import java.util.List;

import com.zealot.dao.InterceptNumberDao;
import com.zealot.entity.InterceptNumber;
import com.zealot.service.InterceptNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zealot.common.Page;
import com.zealot.common.exception.UserBusinessException;
import com.zealot.common.exception.UserSystemException;

@Service
public class InterceptNumberServiceImpl implements InterceptNumberService {
	@Autowired
	private InterceptNumberDao interceptNumberDao;
	
	/**
	 * 添加拦截号码
	 * @param interceptNumber
	 * @throws UserBusinessException
	 */
	public void saveInterceptNumber(InterceptNumber interceptNumber) throws UserBusinessException{
		try {
			interceptNumberDao.saveInterceptNumber(interceptNumber);
		} catch (UserSystemException e) {
			e.printStackTrace();
			throw new UserBusinessException(e);
		}
	}
	
	/**
	 * 修改拦截号码
	 * @param interceptNumber
	 * @throws UserBusinessException
	 */
	public void updateInterceptNumber(InterceptNumber interceptNumber) throws UserBusinessException{
		try {
			interceptNumberDao.updateInterceptNumber(interceptNumber);
		} catch (UserSystemException e) {
			e.printStackTrace();
			throw new UserBusinessException(e);
		}
	}
	
	/**
	 * 删除拦截号码
	 * @param interceptNumber
	 * @throws UserBusinessException
	 */
	public void deleteInterceptNumber(List<InterceptNumber> interceptNumber) throws UserBusinessException{
		try {
			for(InterceptNumber ap : interceptNumber){
				interceptNumberDao.deleteInterceptNumber(ap);
			}
		} catch (UserSystemException e) {
			e.printStackTrace();
			throw new UserBusinessException(e);
		}
	}
	
	/**
	 * 分页查询拦截号码
	 * @param param
	 * @param p
	 * @return
	 * @throws UserBusinessException
	 */
	public List<InterceptNumber> queryInterceptNumberPage(InterceptNumber param,Page p) throws UserBusinessException{
		try {
			List<InterceptNumber> list = interceptNumberDao.queryInterceptNumberPage(param, p);
			p.setTotalRecord(interceptNumberDao.queryInterceptNumberCount(param));
			return list;
		} catch (UserSystemException e) {
			e.printStackTrace();
			throw new UserBusinessException(e);
		}
	}
	
	/**
	 * 条件查询拦截号码
	 * @param param
	 * @return
	 * @throws UserBusinessException
	 */
	public List<InterceptNumber> queryInterceptNumber(InterceptNumber param) throws UserBusinessException{
		try {
			return interceptNumberDao.queryInterceptNumber(param);
		} catch (UserSystemException e) {
			e.printStackTrace();
			throw new UserBusinessException(e);
		}
	}
	/**
	 * 根据主键获取拦截号码
	 * @param interceptNumberId 主键
	 * @return
	 * @throws UserBusinessException
	 */
	public InterceptNumber queryInterceptNumber(String interceptNumberId) throws UserBusinessException{
		try {
			return interceptNumberDao.queryInterceptNumberById(interceptNumberId);
		} catch (UserSystemException e) {
			e.printStackTrace();
			throw new UserBusinessException(e);
		}
	}

	public InterceptNumberDao getInterceptNumberDao() {
		return interceptNumberDao;
	}
	public void setInterceptNumberDao(InterceptNumberDao interceptNumberDao) {
		this.interceptNumberDao = interceptNumberDao;
	}
	
}
