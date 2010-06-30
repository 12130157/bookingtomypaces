/**    
* 
* 版本信息：   
* 日期：2010-4-20   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.common.cache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Vector;

import com.king.base.SpringContextHelper;



public class CacheUtil {
	public static final String DBCACHE = "dbCache";
	public static final String EXCEPTIONCACHE = "exceptionCache";
	public static final String DATACACHE = "dataCache";
	public static final String VOCACHE = "voCache";
	public static final String PARACACHE = "paraCache";

	private static CacheUtil instance = null;
	
	public static ExceptionCache errorCache = null;
	
	public static DBCache dbCache = null;
	
	public static DataCache dataCache = null;

	public static ParaCache paraCache = null;

	private CacheUtil() {
		
	}

	
	public static CacheUtil getInstance() {
		if (instance == null) {
			instance = new CacheUtil();
			CacheUtil.paraCache = (ParaCache) SpringContextHelper
					.getBean(PARACACHE);
			CacheUtil.dataCache = (DataCache) SpringContextHelper
					.getBean(DATACACHE);
			CacheUtil.dbCache = (DBCache) SpringContextHelper.getBean(DBCACHE);
			CacheUtil.errorCache = (ExceptionCache) SpringContextHelper
					.getBean(EXCEPTIONCACHE);
		}
		return instance;
	}

	
	public static ExceptionCache getErrorCache() {
		return errorCache;
	}

	public static DBCache getDbCache() {
		return dbCache;
	}

	public static DataCache getDataCache() {
		return dataCache;
	}



	public static ParaCache getParaCache() {
		return paraCache;
	}

	public HashMap getAssociateMapping(String srcCacheName, String srcID,
			String desCacheName) {
		HashMap rtMap = null;

		TreeMap accMap = getCacheMap(desCacheName + "/" + srcCacheName);
		TreeMap desMap = getCacheMap(desCacheName);

		if (accMap == null || desMap == null)
			return rtMap;

		rtMap = new HashMap();

		java.util.TreeSet set = new java.util.TreeSet(accMap.keySet());
		Iterator iterator = set.iterator();
		Object curkey = null;
		Object key = null;
		Object value = null;
		String tempkey = null;
		String tempkey1 = null;
		String tempkey2 = null;
		String tempValue = null;
		while (iterator.hasNext()) {

			curkey = iterator.next();
			if (curkey.toString().indexOf("/") >= 0) {
				String[] keystr = curkey.toString().split("/");
				tempkey1 = keystr[0].trim();
				tempkey2 = keystr[1].trim();
				tempkey = Integer.toString(Integer.parseInt(tempkey1)
						+ Integer.parseInt(tempkey2));
				key = tempkey;
			} else {
				key = curkey;
			}
			value = accMap.get(curkey);
			tempValue = "";
			if (value != null)
				tempValue = value.toString();
			if (value != null
					&& srcID.length() > 1
					&& srcID.length() < key.toString().length()
					&& (tempValue.toLowerCase().lastIndexOf("$$") == tempValue
							.length() - 2 && tempValue.toLowerCase().indexOf(
							srcID.toLowerCase()) == 0)

			) {
				tempValue = key.toString().substring(srcID.length(),
						key.toString().length());
				rtMap.put(tempValue, desMap.get(tempValue));
			} else if (tempValue.equalsIgnoreCase(srcID)) { 

				String assValue = ("" + (Integer.parseInt(key.toString()) - Integer
						.parseInt(value.toString())));
				rtMap.put(key, desMap.get(assValue));
			}
		}

		return rtMap;
	}

	public java.util.TreeMap getCacheMap(String cacheName) {

		TreeMap dataMap = new TreeMap();
		try {

			TreeMap dataDicMap = getDataCache().getDataMap(cacheName);
			if (dataDicMap != null && !dataDicMap.toString().endsWith("{=}")) {
				dataMap.putAll(dataDicMap);
				return dataMap;
			}
		} catch (Exception ex) {
		}
		try {

			TreeMap DBMap = getDbCache().getDBMap(cacheName);
			if (DBMap != null && !DBMap.toString().endsWith("{=}")) {
				dataMap.putAll(DBMap);
				return dataMap;
			}
		} catch (Exception ex) {
		}

		if (dataMap.size() == 0) {
			dataMap = null;
		}
		return dataMap;
	}

	public java.util.HashMap getCacheHashMap(String cacheName) {

		HashMap dataMap = new HashMap();
		try {

			TreeMap dataDicMap = getDataCache().getDataMap(cacheName);
			if (dataDicMap != null && !dataDicMap.toString().endsWith("{=}")) {
				dataMap.putAll(dataDicMap);
				return dataMap;
			}
		} catch (Exception ex) {
		}
		try {

			TreeMap DBMap = getDbCache().getDBMap(cacheName);
			if (DBMap != null && !DBMap.toString().endsWith("{=}")) {
				dataMap.putAll(DBMap);
				return dataMap;
			}
		} catch (Exception ex) {
		}

		if (dataMap.size() == 0) {
			dataMap = null;
		}
		return dataMap;
	}
	
	public static void removeFromCache(String cacheName, String key) {
		if (cacheName == null || key == null)
			return;

		TreeMap cacheMap = CacheUtil.getDbCache().getDBMap(cacheName);

		if (cacheMap == null) {
			return;
		}
		synchronized (cacheMap) {
			cacheMap.remove(key);
		}

	}


	public static int updateCache(String cacheName, String key, int posIndex,
			String value) {
		int rtFlag = 0;

		if (cacheName == null || key == null || posIndex < 0) {
			rtFlag = -1;
			return rtFlag;
		}

		TreeMap cacheMap = CacheUtil.getDbCache().getDBMap(cacheName);
		if (cacheMap == null) {
			rtFlag = -2;
			return rtFlag;
		}

		Object cacheValue = cacheMap.get(key);
		if (cacheValue == null) {
			rtFlag = -3;
			return rtFlag;
		} else if (cacheValue instanceof Vector) {
			if ((((Vector) cacheValue).size()) <= posIndex) {
				rtFlag = -4;
				return rtFlag;
			} else {
				synchronized (cacheMap) {
					((Vector) cacheValue).remove(posIndex);
					((Vector) cacheValue).add(posIndex, value);
					cacheMap.put(key, cacheValue);
				}
			}
		} else if(cacheValue instanceof TreeMap){
			synchronized (cacheMap) {
				((TreeMap)cacheValue).remove(key);
				((TreeMap)cacheValue).put(key, value);
				cacheMap.put(key, cacheValue);
			}
		}
		
		else {
			rtFlag = -5; 
			return rtFlag;
		}

		return rtFlag;
	}
	
	public static void addToCache(String cacheName, String key, TreeMap value) {
		if (cacheName == null || key == null || value == null)
			return;

		TreeMap cacheMap = CacheUtil.getDbCache().getDBMap(cacheName);
		if (cacheMap == null) {
			return;
		}

		synchronized (cacheMap) {
			cacheMap.put(key, value);
		}
	}
}
