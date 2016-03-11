package com.zealot.service.impl;

import java.util.List;

import com.zealot.service.InterceptRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zealot.common.Page;
import com.zealot.dao.InterceptRecordDao;
import com.zealot.entity.InterceptRecord;
import com.zealot.common.exception.UserBusinessException;
import com.zealot.common.exception.UserSystemException;

@Service
public class InterceptRecordServiceImpl implements InterceptRecordService {
	@Autowired
	private InterceptRecordDao interceptRecordDao;
	
	/**
	 * 添加拦截号码
	 * @param interceptRecord
	 * @throws UserBusinessException
	 */
	public void saveInterceptRecord(InterceptRecord interceptRecord) throws UserBusinessException{
		try {
			interceptRecordDao.saveInterceptRecord(interceptRecord);
		} catch (UserSystemException e) {
			e.printStackTrace();
			throw new UserBusinessException(e);
		}
	}
	
	/**
	 * 修改拦截号码
	 * @param interceptRecord
	 * @throws UserBusinessException
	 */
	public void updateInterceptRecord(InterceptRecord interceptRecord) throws UserBusinessException{
		try {
			interceptRecordDao.updateInterceptRecord(interceptRecord);
		} catch (UserSystemException e) {
			e.printStackTrace();
			throw new UserBusinessException(e);
		}
	}
	
	/**
	 * 删除拦截号码
	 * @param interceptRecord
	 * @throws UserBusinessException
	 */
	public void deleteInterceptRecord(List<InterceptRecord> interceptRecord) throws UserBusinessException{
		try {
			for(InterceptRecord ap : interceptRecord){
				interceptRecordDao.deleteInterceptRecord(ap);
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
	public List<InterceptRecord> queryInterceptRecordPage(InterceptRecord param,Page p) throws UserBusinessException{
		try {
			List<InterceptRecord> list = interceptRecordDao.queryInterceptRecordPage(param, p);
			p.setTotalRecord(interceptRecordDao.queryInterceptRecordCount(param));
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
	public List<InterceptRecord> queryInterceptRecord(InterceptRecord param) throws UserBusinessException{
		try {
			return interceptRecordDao.queryInterceptRecord(param);
		} catch (UserSystemException e) {
			e.printStackTrace();
			throw new UserBusinessException(e);
		}
	}
	/**
	 * 根据主键获取拦截号码
	 * @param interceptRecordId 主键
	 * @return
	 * @throws UserBusinessException
	 */
	public InterceptRecord queryInterceptRecord(String interceptRecordId) throws UserBusinessException{
		try {
			return interceptRecordDao.queryInterceptRecordById(interceptRecordId);
		} catch (UserSystemException e) {
			e.printStackTrace();
			throw new UserBusinessException(e);
		}
	}

	public InterceptRecordDao getInterceptRecordDao() {
		return interceptRecordDao;
	}
	public void setInterceptRecordDao(InterceptRecordDao interceptRecordDao) {
		this.interceptRecordDao = interceptRecordDao;
	}
	
}
