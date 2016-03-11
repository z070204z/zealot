/**
 * 
 */
package com.zealot.common;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zealot.common.exception.UserSystemException;

/**
 * @author lp
 * 数据操作基类
 */
@SuppressWarnings("rawtypes")
public class BaseDao extends HibernateDaoSupport{
	
	@Autowired
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}

	/**
	 * 批量添加数据
	 * @param objLis
	 * @throws Exception 
	 */
	protected void save(List objLis) throws UserSystemException{
		try {
			Session session = this.getSession();
			for (int i = 0; i < objLis.size(); i++) {
				session.save(objLis.get(i));
			}
			session.flush();
		} catch (Exception e) {
			throw new UserSystemException("插入数据出错------------"+e.getMessage());
		}
	}
	/**
	 * 添加单条数据
	 * @param obj
	 * @throws Exception 
	 */
	protected void save(Object obj) throws UserSystemException{
		try {
			Session session = this.getSession();
			session.save(obj);
			session.flush();
		} catch (Exception e) {
			e.printStackTrace();
			throw new UserSystemException("插入数据出错------------"+e.getMessage());
		}
	}
	/**
	 * 批量修改
	 * @param objLis
	 * @throws Exception
	 */
	protected void update(List objLis)throws UserSystemException{
		try {
			Session session = this.getSession();
			for (int i = 0; i < objLis.size(); i++) {
				session.update(objLis.get(i));
			}
			session.flush();
		} catch (Exception e) {
			throw new UserSystemException("修改数据出错------------"+e.getMessage());
		}
		
	}
	/**
	 * 修改单条数据
	 * @param obj
	 * @throws Exception
	 */
	protected void update(Object obj)throws UserSystemException{
		try {
			Session session = this.getSession();
			session.clear();
			session.update(obj);
			session.flush();
		} catch (Exception e) {
			e.printStackTrace();
			throw new UserSystemException("修改数据出错------------"+e.getMessage());
		}
	}
	/**
	 * 根据条件修改数据
	 * @param sql
	 * @param param
	 * @throws Exception
	 */
	protected int update(String sql,List param)throws UserSystemException{
		try {
			Session session = this.getSession();
			Query query = session.createQuery(sql);
			for (int i = 0; i < param.size(); i++) {
				query.setParameter(i, param.get(i));
			}
			int count =  query.executeUpdate();
			session.flush();
			return count;
		} catch (Exception e) {
			throw new UserSystemException("修改数据出错------------"+e.getMessage());
		}
	}
	/**
	 * 根据条件修改数据
	 * @param sql
	 * @param param
	 * @throws Exception
	 */
	protected int updateSql(String sql,List param)throws UserSystemException{
		try {
			Session session = this.getSession();
			Query query = session.createSQLQuery(sql);
			for (int i = 0; i < param.size(); i++) {
				query.setParameter(i, param.get(i));
			}
			int count =  query.executeUpdate();
			session.flush();
			return count;
		} catch (Exception e) {
			throw new UserSystemException("修改数据出错------------"+e.getMessage());
		}
	}
	/**
	 * 删除数据
	 * @param obj
	 * @throws Exception
	 */
	protected void delete(Object obj)throws UserSystemException{
		try {
			Session session = this.getSession();
			session.delete(obj);
			session.flush();
		} catch (Exception e) {
			throw new UserSystemException("删除数据出错------------"+e.getMessage());
		}
	}
	/**
	 * 根据条件删除数据
	 * @param sql
	 * @param param
	 * @throws Exception
	 */
	protected void delete(String sql,List param) throws UserSystemException{
		try {
			Session session = this.getSession();
			Query query = session.createQuery(sql);
			if(param!=null&&param.size()>0){
				for (int i = 0; i < param.size(); i++) {
					query.setParameter(i, param.get(i));
				}
			}
			query.executeUpdate();
			session.flush();
		} catch (Exception e) {
			e.printStackTrace();
			throw new UserSystemException("删除数据出错------------"+e.getMessage());
		}
	}
	/**
	 * 根据条件查询单个对象
	 * @param sql
	 * @param param
	 * @return
	 * @throws Exception
	 */
	protected Object find(String sql,List param)throws UserSystemException{
		try {
			Session session = this.getSession();
			Query query = session.createQuery(sql);
			if(param!=null&&param.size()>0){
				for (int i = 0; i < param.size(); i++) {
					query.setParameter(i, param.get(i));
				}
			}
			List list=query.list();
			if(list!=null&&list.size()>0){
				return list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new UserSystemException("查询数据出错------------"+e.getMessage());
		}
		return null;
	}
	/**
	 * 根据条件查询多条数据
	 * @param sql
	 * @param param
	 * @return
	 * @throws Exception
	 */
	protected  List findSQLList(String sql,List param,Class clz)throws UserSystemException{
		try {
			Session session = this.getSession();
			Query query = session.createSQLQuery(sql).addEntity(clz);
			if(null!=param&&param.size()>0){
				for (int i = 0; i < param.size(); i++) {
					query.setParameter(i, param.get(i));
				}
			}
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new UserSystemException("查询数据出错------------"+e.getMessage());
		}
	}
	/**
	 * 根据条件查询多条数据
	 * @param sql
	 * @param param
	 * @return
	 * @throws Exception
	 */
	protected  List findSQLList(String sql,List param)throws UserSystemException{
		try {
			Session session = this.getSession();
			Query query = session.createSQLQuery(sql);
			if(null!=param&&param.size()>0){
				for (int i = 0; i < param.size(); i++) {
					query.setParameter(i, param.get(i));
				}
			}
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new UserSystemException("查询数据出错------------"+e.getMessage());
		}
	}
	/**
	 * 根据条件查询多条数据
	 * @param sql
	 * @param param
	 * @return
	 * @throws Exception
	 */
	protected  List findList(String sql,List param)throws UserSystemException{
		try {
			Session session = this.getSession();
			Query query = session.createQuery(sql);
			if(null!=param&&param.size()>0){
				for (int i = 0; i < param.size(); i++) {
					query.setParameter(i, param.get(i));
				}
			}
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new UserSystemException("查询数据出错------------"+e.getMessage());
		}
	}
	
	/**
	 * 根据数量
	 * @param sql
	 * @param param
	 * @return
	 * @throws Exception
	 */
	protected  Integer findCount(String sql,List param)throws UserSystemException{
		try {
			Session session = this.getSession();
			Query query = session.createQuery(sql);
			if(null!=param&&param.size()>0){
				for (int i = 0; i < param.size(); i++) {
					query.setParameter(i, param.get(i));
				}
			}
			
			return query.uniqueResult()==null ? 0 : ((Number)query.uniqueResult()).intValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new UserSystemException("查询数据出错------------"+e.getMessage());
		}
	}
	
	/**
	 * 根据数量
	 * @param sql
	 * @param param
	 * @return
	 * @throws Exception
	 */
	protected  Integer findSQLCount(String sql,List param)throws UserSystemException{
		try {
			Session session = this.getSession();
			Query query = session.createSQLQuery(sql);
			if(null!=param&&param.size()>0){
				for (int i = 0; i < param.size(); i++) {
					query.setParameter(i, param.get(i));
				}
			}
			return query.uniqueResult()==null ? 0 : ((Number)query.uniqueResult()).intValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new UserSystemException("查询数据出错------------"+e.getMessage());
		}
	}
	
	/**
	 * 分页查询
	 * @param sql
	 * @param param
	 * @param page
	 * @return
	 * @throws Exception
	 */
	protected  List findListByPage(String sql,List param,Page page)throws UserSystemException{
		try {
			Session session = this.getSession();
			Query query = session.createQuery(sql);
			if(null!=param&&param.size()>0){
				for (int i = 0; i < param.size(); i++) {
					query.setParameter(i, param.get(i));
				}
			}
			if(page!=null){
				query.setFirstResult(page.getPage() * page.getPagesize() - page.getPagesize());
				query.setMaxResults(page.getPagesize());
			}
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new UserSystemException("分页查询数据出错------------"+e.getMessage());
		}
	}
	/**
	 * 分页查询
	 * @param sql
	 * @param param
	 * @param page
	 * @return
	 * @throws Exception
	 */
	protected  List findListByPage(String sql,List param,Integer start,Integer count)throws UserSystemException{
		try {
			Session session = this.getSession();
			Query query = session.createQuery(sql);
			if(null!=param&&param.size()>0){
				for (int i = 0; i < param.size(); i++) {
					query.setParameter(i, param.get(i));
				}
			}
				query.setFirstResult(start);
				query.setMaxResults(count);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new UserSystemException("分页查询数据出错------------"+e.getMessage());
		}
	}
	/**
	 * 分页查询
	 * @param sql
	 * @param param
	 * @param page
	 * @return
	 * @throws Exception
	 */
	protected  List findListBySQLPage(String sql,List param,Page page)throws UserSystemException{
		try {
			Session session = this.getSession();
			Query query = session.createSQLQuery(sql);
			if(null!=param&&param.size()>0){
				for (int i = 0; i < param.size(); i++) {
					query.setParameter(i, param.get(i));
				}
			}
			if(page!=null){
				query.setFirstResult(page.getPage() * page.getPagesize() - page.getPagesize());
				query.setMaxResults(page.getPagesize());
			}
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new UserSystemException("分页查询数据出错------------"+e.getMessage());
		}
	}
}
