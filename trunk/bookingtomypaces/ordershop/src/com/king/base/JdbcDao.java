/**    
* 
* 版本信息：   
* 日期：2010-4-20   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.king.base.IDao;
import com.king.base.IData;
import com.king.common.exception.KINGException;

public class JdbcDao extends JdbcDaoSupport implements IDao {

	private String driverName = "";

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public void executeSQL(String sql) throws KINGException {
		try {
			this.getJdbcTemplate().execute(sql);
		} catch (DataAccessException ex) {
			throw new KINGException("JdbcDao_executeSQL", ex);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void executeSQL(String sql, Object[] parameters)
			throws KINGException {
		try {
			if (parameters == null) {
				this.getJdbcTemplate().execute(sql);
			} else {
				this.getJdbcTemplate().update(sql, parameters);
			}

		} catch (DataAccessException ex) {
			throw new KINGException("JdbcDao_update", ex);
		}
	}

	public void executeUpdate(String sql, Object[] parameters)
			throws KINGException {
		try {
			if (parameters == null) {
				this.getJdbcTemplate().update(sql);
			} else {
				this.getJdbcTemplate().update(sql, parameters);
			}

		} catch (DataAccessException ex) {
			throw new KINGException("JdbcDao_update", ex);
		}
	}

	public List<PublicResultSet> queryForList(String sql, Object[] parameters)
			throws KINGException {
		try {
			List result = null;
			if (parameters == null) {
				result = this.getJdbcTemplate().queryForList(sql);
			} else {
				result = this.getJdbcTemplate().queryForList(sql, parameters);
			}
			List<PublicResultSet> rv = new ArrayList();
			for (int i = 0; i < result.size(); i++) {
				PublicResultSet newItem = new PublicResultSet();
				newItem.putAll((Map) result.get(i));
				rv.add(newItem);
			}
			return rv;
		} catch (DataAccessException ex) {
			throw new KINGException("JdbcDao_queryForList", ex);
		}
	}
	
	public List<IData> queryForObjectList(String sql, Object[] parameters,
			IResultSetMap queryMap) throws KINGException {
		try {
			List result = null;
			if (parameters == null) {
				result = this.getJdbcTemplate().queryForList(sql);
			} else {
				result = this.getJdbcTemplate().queryForList(sql, parameters);
			}
			PublicResultSet[] rv = new PublicResultSet[result.size()];
			for (int i = 0; i < result.size(); i++) {
				rv[i] = new PublicResultSet();
				Map resulti = (Map) result.get(i);
				Object[] keys = resulti.keySet().toArray();
				for(int j=0;j<keys.length;j++){
					rv[i].put(keys[j],resulti.get(keys[j]));
				}
			}

			List<IData> rvList = new ArrayList();
			for (int i = 0; i < rv.length; i++) {
				rvList.add((IData)queryMap.map(rv[i]));
			}
			return rvList;
		} catch (DataAccessException ex) {
			throw new KINGException("JdbcDao_queryForObjectList", ex);
		}
	}
}
