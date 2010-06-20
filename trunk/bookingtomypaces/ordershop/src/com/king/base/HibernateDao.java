/**    
* 
* 版本信息：   
* 日期：2010-4-20   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.base;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.list.TreeList;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.king.base.IDao;
import com.king.base.IData;
import com.king.common.exception.KINGError;
import com.king.tools.PageRoll;

public class HibernateDao extends HibernateDaoSupport implements IDao {

	public void delete(IData data) {
		// TODO Auto-generated method stub
		try {
			getHibernateTemplate().delete(data);
		} catch (DataAccessException ex) {
			throw new KINGError("Hibernate_delete", ex);
		}

	}

	/**
	 * 使用指定的id,加载对象
	 * 
	 * @param cls
	 *            类
	 * @param id
	 *            主键
	 * @return 记录对象
	 */
	public IData load(Class cls, Object id) {
		Session session = null;
		try {
			session = getHibernateTemplate().getSessionFactory().openSession();
			Object rtnObj = session.load(cls, (Serializable) id);
			// 未取得对象，就直接返回null
			if (rtnObj == null) {
				return null;
			}
			/*
			 * 如果返回值中存在set或list，而且方法名为get开头的，那么就加载一次，这是为了主动进行懒加载
			 * 以下代码存在效率浪费，将所有属性遍历一次挺花时间的，如果需要提高效率，最好将这段代码独立出来
			 * 人工主动调用。
			 * 
			 */
			Method[] methods = rtnObj.getClass().getMethods();
			String rvType = null;
			for (int j = 0; j < methods.length; j++) {
				rvType = methods[j].getReturnType().getName().toLowerCase();
				if ((rvType.equals("java.util.set")
						|| rvType.equals("java.util.list") && methods[j].getName().startsWith("get"))) {
					try {
						Hibernate.initialize(methods[j].invoke(rtnObj, null));
					} catch (Exception ex) {
						ex.printStackTrace();
						throw new KINGError("Hibernate_load", ex);
					}
				}
			}

			return (IData) rtnObj;
		} catch (KINGError e1) {
			throw new KINGError("HibernateHelper_load", e1);
		} finally {
			try {
				session.flush();
			} catch (HibernateException e2) {
				e2.printStackTrace();
				throw new KINGError("HibernateHelper_load", e2);
			}
			try {
				session.close();
			} catch (HibernateException e3) {
				throw new KINGError("HibernateHelper_load", e3);
			}
		}

	}

	public List<IData> loadAll(Class entityClass) {
		// TODO Auto-generated method stub
		try {
			return getHibernateTemplate().loadAll(entityClass);
		} catch (DataAccessException ex1) {
			throw new KINGError("hibernate_loadAll", ex1);
		}
	}

	public void save(IData data) {
		// TODO Auto-generated method stub
		try {
			Object ID = getHibernateTemplate().save(data);

		} catch (DataAccessException ex) {
			ex.printStackTrace();
			throw new KINGError("Hibernate_save", ex);
		}
	}

	public List<? extends IData> search(String hql) {
		// TODO Auto-generated method stub
		try {
			return getHibernateTemplate().find(hql);
		} catch (DataAccessException ex1) {
			ex1.printStackTrace();
			throw new KINGError("hibernate_search_hql", ex1);
		}
	}

	public List<? extends IData> search(String hql, Object[] parameters) {
		// TODO Auto-generated method stub
		try {
			return getHibernateTemplate().find(hql, parameters);
		} catch (DataAccessException ex1) {
			ex1.printStackTrace();
			throw new KINGError("hibernate_search_hql", ex1);
		}
	}

	public List<? extends IData> search(final PageRoll pageRoll) {
		// TODO Auto-generated method stub
		try {
			return getHibernateTemplate().executeFind(new HibernateCallback() {
				public List doInHibernate(Session session)
						throws HibernateException, SQLException {
					String countSQL = pageRoll.getCountSQL();
					Query query = session.createQuery(countSQL);
					long count = ((Long) query.list().get(0)).longValue();
					pageRoll.setTotalRows((int) count);
					if (count == 0) {
						return new TreeList();
					}
					String searchSQL = pageRoll.getSearchSQL();
					query = session.createQuery(searchSQL);
					if (pageRoll.getPageSize() > 0) {
						query.setFirstResult(pageRoll.getStartRow());
						query.setMaxResults(pageRoll.getPageSize());
					}

					return query.list();

				}
			});
		} catch (DataAccessException ex1) {
			ex1.printStackTrace();
			throw new KINGError("hibernateHelper_search_page", ex1);
		}
	}
	
	public List<? extends IData> searchlist(PageRoll pageRoll,String withhql) {
		Session session = null;
		try {
			        session = getHibernateTemplate().getSessionFactory().openSession();
					String countSQL = pageRoll.getCountSQL();
					Query query = session.createQuery(countSQL + withhql);
					long count = ((Long) query.list().get(0)).longValue();
					pageRoll.setTotalRows((int) count);
					if (count == 0) {
						return new TreeList();
					}
					String searchSQL = pageRoll.getSearchSQL();
					query = session.createQuery(searchSQL+ withhql);
					if (pageRoll.getPageSize() > 0) {
						query.setFirstResult((pageRoll.getStartRow() - 1) * pageRoll.getPageSize())
						.setMaxResults(pageRoll.getPageSize());
						
						//query.setFirstResult(pageRoll.getStartRow());
						//query.setMaxResults(pageRoll.getPageSize());
					}

					return query.list();

			
		} catch (HibernateException e) {
			throw new KINGError("hibernate_search_sql_page", e);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			session.flush();
			session.close();
		}
	}

	public void update(IData data) {
		// TODO Auto-generated method stub

		Session session = null;
		try {
			session = getHibernateTemplate().getSessionFactory().openSession();
			// Object loadObj =
			// session.load(data.getClass(),(Serializable)data.getId());
			// java.lang.reflect.Field[] fields = data.getClass().getFields();
			// //String typeName = null;
			// for (int i = 0; i < fields.length; i++) {
			// String typeName = fields[i].getType().getName();
			// //子表属性
			// if
			// (typeName.equals("java.util.list")||typeName.equals("java.util.List"))
			// {
			// //现有的子表属性
			// java.util.List targetSet =
			// (java.util.List)fields[i].get(loadObj);
			// //新对象子表属性。
			// java.util.List sourceSet = (java.util.List)fields[i].get(data);
			// //清除已有的子表
			// targetSet.clear();
			// //添加新子表
			// java.util.Iterator iters = sourceSet.iterator();
			// while (iters.hasNext()) {
			// targetSet.add(iters.next());
			// }
			// }
			// //其它属性直接设置
			// else if (
			// typeName.equals("int")
			// || typeName.equals("long")
			// || typeName.equals("float")
			// || typeName.equals("double")
			// || typeName.equals("boolean")
			// || typeName.equals("java.lang.Float")
			// || typeName.equals("java.lang.Integer")
			// || typeName.equals("java.lang.Double")
			// || typeName.equals("java.sql.Date")
			// || typeName.equals("java.sql.Timestamp")
			// || typeName.equals("java.util.Date")
			// || typeName.equals("java.lang.Long")
			// || typeName.equals("java.lang.String")) {
			// fields[i].set(loadObj, fields[i].get(data));
			// }
			// }
			// 更新对象
			getHibernateTemplate().update(data);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new KINGError("Hibernate_update", e1);
		} finally {
			try {
				session.flush();
			} catch (HibernateException e2) {
				e2.printStackTrace();
				throw new KINGError("Hibernate_update", e2);
			}
			try {
				session.close();
			} catch (HibernateException e3) {
				e3.printStackTrace();
				throw new KINGError("Hibernate_update", e3);
			}
		}

	}

	public IData retrieve(Class cls, Serializable id) {
		try {
			return (IData) getHibernateTemplate().get(cls, id);
		} catch (DataAccessException ex) {
			ex.printStackTrace();
			throw new KINGError("Hibernate_load", ex);
		}
	}

	public void saveOrUpdate(IData data) {
		try {
			getHibernateTemplate().saveOrUpdate(data);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new KINGError("Hibernate_saveOrUpdate", e);
		}
	}

	public void saveOrUpdateAll(Collection<IData> datas) {
		try {
			getHibernateTemplate().saveOrUpdateAll(datas);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new KINGError("Hibernate_saveOrUpdateAll", e);
		}
	}

	/**
	 * 不带分页的sql语句查询，此处必须是SqlQuery配置项
	 * 
	 * @param sqlName
	 *            sqlQuery名称
	 * @param entities
	 *            sql语句执行完成后，结果集对象类型。
	 * @param parameters
	 *            sql语句中的参数映射表，要求每个参数采用name,value方式放入到map中，而且value必须是对象类型。
	 * @return 返回值列表，列表的每个元素是IData数组。
	 * @throws KINGError
	 *             hibernate_search_sql_page 查询时由于Hibernate
	 *             API抛出的错误，可能是数据库系统错误或Hibernate报错
	 */
	public List searchBySQL(String sqlName, Map parameters) {
		Session session = null;
		List list = null;

		try {
			session = getHibernateTemplate().getSessionFactory().openSession();
			// res=session.().createStatement().execute(sql);
			Query query = session.getNamedQuery(sqlName);
			Object[] keys = parameters.keySet().toArray();
			for (Object key : keys) {
				query.setParameter((String) key, parameters.get(key));
			}
			SQLQuery sqlQuery = (SQLQuery) query;
			list = sqlQuery.list();
			return list;
		} catch (HibernateException e) {
			throw new KINGError("hibernate_search_sql_page", e);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			session.flush();
			session.close();
		}
	}

	/**
	 * 带分页的sql语句查询，此处必须是SqlQuery配置项
	 * 
	 * @param sqlName
	 *            sqlQuery名称
	 * @param entities
	 *            sql语句执行完成后，结果集对象。
	 * @param parameters
	 *            sql语句中的参数映射表，要求每个参数采用name,value方式放入到map中，而且value必须是对象类型。
	 * @param offset
	 *            开始查询的记录数。
	 * @param length
	 *            查询的记录长度
	 * @return 返回值列表，列表的每个元素是IData数组。
	 * @throws KINGError
	 *             hibernate_search_sql_page 查询时由于Hibernate
	 *             API抛出的错误，可能是数据库系统错误或Hibernate报错
	 */
	public List searchBySQLWithPage(String sqlName, Map parameters, int offset,
			int length) {
		Session session = null;
		List list = null;
		try {
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.getNamedQuery(sqlName);
			Object[] keys = parameters.keySet().toArray();
			for (Object key : keys) {
				query.setParameter((String) key, parameters.get(key));
			}
			query.setFirstResult(offset);
			query.setMaxResults(length);
			SQLQuery sqlQuery = (SQLQuery) query;
			list = sqlQuery.list();
			return list;
		} catch (HibernateException e) {
			throw new KINGError("hibernate_search_sql_page", e);
		} finally {
			session.flush();
			session.close();
		}

	}

	/**
	 * 调用配置文件中的sql语句，用于更新
	 * 
	 * @param sqlName
	 *            hibernate配置文件中sql名字，可以使Query和sqlQuery配置。
	 * @param parameters
	 *            sql语句中的参数，要求使用name,value放置到map中，并且所有的value类型都必须是Object。
	 * @return 更新影响的的记录数
	 * @throws KINGError
	 *             hibernate_search_sql_update 更新时由于Hibernate
	 *             API抛出的错误，可能是数据库系统错误或Hibernate报错
	 */
	public int updateBySQL(String sqlName, Map parameters) {
		Session session = null;
		int result = 0;
		try {
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.getNamedQuery(sqlName);
			Object[] keys = parameters.keySet().toArray();
			for (Object key : keys) {
				query.setParameter((String) key, parameters.get(key));
			}
			return result;
		} catch (HibernateException e) {
			throw new KINGError("hibernate_search_sql_update", e);
		} finally {
			session.flush();
			session.close();
		}
	}

	/**
	 * 暂时保留，用于更新字段,2009-4-22
	 */
	public int updateBySQL(String sql) {
		Session session = null;
		int result = 0;
		try {
			session = getHibernateTemplate().getSessionFactory().openSession();
			result = session.createSQLQuery(sql).executeUpdate();
			return result;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new KINGError("hibernate_search_sql_update", e);
		} finally {
			session.flush();
			session.close();
		}

	}

}
