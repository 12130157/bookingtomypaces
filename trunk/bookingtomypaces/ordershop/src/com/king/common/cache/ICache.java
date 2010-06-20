/**    
* 
* 版本信息：   
* 日期：2010-4-20   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.common.cache;

import java.util.Map;

public interface ICache {

	public Object read(Object key) throws CacheException;
	
	public Object get(Object key) throws CacheException;
	
	public void put(Object key, Object value) throws CacheException;
	
	public void update(Object key, Object value) throws CacheException;
	
	public void remove(Object key) throws CacheException;
	
	public void clear() throws CacheException;
	
	public void destroy() throws CacheException;
	
	public long nextTimestamp();
	
	public int getTimeout();
	
	public String getRegionName();
	
	public long getSizeInMemory();
	
	public long getElementCountInMemory();
	
	public long getElementCountOnDisk();
	
	public Map toMap();
}
