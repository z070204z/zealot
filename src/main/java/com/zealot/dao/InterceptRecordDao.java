package com.zealot.dao;

import java.util.ArrayList;
import java.util.List;

import com.zealot.entity.InterceptRecord;
import org.springframework.stereotype.Repository;

import com.zealot.common.BaseDao;
import com.zealot.common.DateHelper;
import com.zealot.common.Page;
import com.zealot.common.exception.UserSystemException;

@SuppressWarnings("unchecked")
@Repository
public class InterceptRecordDao extends BaseDao{
	
	/**
	 * 添加拦截记录
	 * @param interceptRecord
	 * @throws UserSystemException
	 */
	public void saveInterceptRecord(InterceptRecord interceptRecord) throws UserSystemException{
		try {
			interceptRecord.setInterceptTime(DateHelper.getCurrentDateTime());
			super.save(interceptRecord);
		} catch (Exception e) {
			throw new UserSystemException(e);
		}
	}
	
	/**
	 * 修改拦截记录
	 * @param interceptRecord
	 * @throws UserSystemException
	 */
	public void updateInterceptRecord(InterceptRecord interceptRecord) throws UserSystemException{
		try {
			super.update(interceptRecord);
		} catch (Exception e) {
			throw new UserSystemException(e);
		}
	}
	
	/**
	 * 删除拦截记录
	 * @throws UserSystemException
	 */
	public void deleteInterceptRecord(InterceptRecord interceptRecord) throws UserSystemException{
		try {
			super.delete(interceptRecord);
		} catch (Exception e) {
			throw new UserSystemException(e);
		}
	}
	
	/**
	 * 条件查询拦截记录
	 * @return
	 * @throws UserSystemException
	 */
	public List<InterceptRecord> queryInterceptRecord(InterceptRecord param) throws UserSystemException{
		try {
			String sql = "from InterceptRecord where 1=1 ";
			List<Object> queryParam = new ArrayList<Object>();
			return  super.findList(sql, queryParam);
		} catch (Exception e) {
			throw new UserSystemException(e);
		}
	}
	
	/**
	 * 分页查询拦截记录
	 * @return
	 * @throws UserSystemException
	 */
	public List<InterceptRecord> queryInterceptRecordPage(InterceptRecord param,Page p) throws UserSystemException{
		try {
			String sql = "from InterceptRecord where 1=1 ";
			List<Object> queryParam = new ArrayList<Object>();
			if(param != null){
				if(param.getPhone()!=null && !"".equals(param.getPhone())){
					sql += " and phone like ? ";
					queryParam.add("%"+param.getPhone()+"%");
				}
				if(param.getInterceptNumber()!=null && !"".equals(param.getInterceptNumber())){
					sql += " and interceptNumber like ? ";
					queryParam.add("%"+param.getInterceptNumber()+"%");
				}
				if(param.getInterceptContent()!=null && !"".equals(param.getInterceptContent())){
					sql += " and interceptContent like ? ";
					queryParam.add("%"+param.getInterceptContent()+"%");
				}
				if(param.getStartTime()!=null && !"".equals(param.getStartTime())){
					sql += " and interceptTime > ? ";
					queryParam.add(param.getStartTime());
				}
				if(param.getEndTime()!=null && !"".equals(param.getEndTime())){
					sql += " and interceptTime < ? ";
					queryParam.add(param.getEndTime());
				}
			}
			return super.findListByPage(sql, queryParam, p);
		} catch (Exception e) {
			throw new UserSystemException(e);
		}
	}
	
	/**
	 * 分页查询拦截记录总数
	 * @return
	 */
	public Integer queryInterceptRecordCount(InterceptRecord param) throws UserSystemException {
		try {
			String sql = "select count(*) from InterceptRecord where 1=1 ";
			List<Object> queryParam = new ArrayList<Object>();
			if(param != null){
				if(param.getPhone()!=null && !"".equals(param.getPhone())){
					sql += " and phone like ? ";
					queryParam.add("%"+param.getPhone()+"%");
				}
				if(param.getInterceptNumber()!=null && !"".equals(param.getInterceptNumber())){
					sql += " and interceptNumber like ? ";
					queryParam.add("%"+param.getInterceptNumber()+"%");
				}
				if(param.getInterceptContent()!=null && !"".equals(param.getInterceptContent())){
					sql += " and interceptContent like ? ";
					queryParam.add("%"+param.getInterceptContent()+"%");
				}
			}
			return super.findCount(sql, queryParam);
		} catch (Exception e) {
			throw new UserSystemException(e);
		}
	}
	
	/**
	 * 根据主键获取拦截记录
	 * @param interceptRecordId
	 * @return
	 * @throws UserSystemException
	 */
	@SuppressWarnings("rawtypes")
	public InterceptRecord queryInterceptRecordById(String interceptRecordId)throws UserSystemException{
		try {
			String sql = "from InterceptRecord  where id = ? ";
			List param = new ArrayList();
			param.add(interceptRecordId);
			return (InterceptRecord)super.find(sql, param);
		} catch (Exception e) {
			throw new UserSystemException(e);
		}
	}
}
