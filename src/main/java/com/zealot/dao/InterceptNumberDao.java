package com.zealot.dao;

import com.zealot.common.BaseDao;
import com.zealot.common.Page;
import com.zealot.common.exception.UserSystemException;
import com.zealot.entity.InterceptNumber;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
@Repository
public class InterceptNumberDao extends BaseDao{
	
	/**
	 * 添加拦截号码
	 * @param interceptNumber
	 * @throws UserSystemException
	 */
	public void saveInterceptNumber(InterceptNumber interceptNumber) throws UserSystemException{
		try {
			super.save(interceptNumber);
		} catch (Exception e) {
			throw new UserSystemException(e);
		}
	}
	
	/**
	 * 修改拦截号码
	 * @param interceptNumber
	 * @throws UserSystemException
	 */
	public void updateInterceptNumber(InterceptNumber interceptNumber) throws UserSystemException{
		try {
			super.update(interceptNumber);
		} catch (Exception e) {
			throw new UserSystemException(e);
		}
	}
	
	/**
	 * 删除拦截号码
	 * @throws UserSystemException
	 */
	public void deleteInterceptNumber(InterceptNumber interceptNumber) throws UserSystemException{
		try {
			super.delete(interceptNumber);
		} catch (Exception e) {
			throw new UserSystemException(e);
		}
	}
	
	/**
	 * 条件查询拦截号码
	 * @return
	 * @throws UserSystemException
	 */
	public List<InterceptNumber> queryInterceptNumber(InterceptNumber param) throws UserSystemException{
		try {
			String sql = "from InterceptNumber where 1=1 ";
			List<Object> queryParam = new ArrayList<Object>();
			return  super.findList(sql, queryParam);
		} catch (Exception e) {
			throw new UserSystemException(e);
		}
	}
	
	/**
	 * 分页查询拦截号码
	 * @return
	 * @throws UserSystemException
	 */
	public List<InterceptNumber> queryInterceptNumberPage(InterceptNumber param,Page p) throws UserSystemException{
		try {
			String sql = "from InterceptNumber where 1=1 ";
			List<Object> queryParam = new ArrayList<Object>();
			if(param != null){
				if(param.getNumber()!=null && !"".equals(param.getNumber())){
					sql += " and number like ? ";
					queryParam.add("%"+param.getNumber()+"%");
				}
			}
			return super.findListByPage(sql, queryParam, p);
		} catch (Exception e) {
			throw new UserSystemException(e);
		}
	}
	
	/**
	 * 分页查询拦截号码总数
	 * @return
	 */
	public Integer queryInterceptNumberCount(InterceptNumber param) throws UserSystemException {
		try {
			String sql = "select count(*) from InterceptNumber where 1=1 ";
			List<Object> queryParam = new ArrayList<Object>();
			if(param != null){
				if(param.getNumber()!=null && !"".equals(param.getNumber())){
					sql += " and number like ? ";
					queryParam.add("%"+param.getNumber()+"%");
				}
			}
			return super.findCount(sql, queryParam);
		} catch (Exception e) {
			throw new UserSystemException(e);
		}
	}
	
	/**
	 * 根据主键获取拦截号码
	 * @param interceptNumberId
	 * @return
	 * @throws UserSystemException
	 */
	@SuppressWarnings("rawtypes")
	public InterceptNumber queryInterceptNumberById(String interceptNumberId)throws UserSystemException{
		try {
			String sql = "from InterceptNumber  where id = ? ";
			List param = new ArrayList();
			param.add(interceptNumberId);
			return (InterceptNumber)super.find(sql, param);
		} catch (Exception e) {
			throw new UserSystemException(e);
		}
	}
}
