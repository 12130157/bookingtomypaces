/**    
* 
* 版本信息：   
* 日期：2010-4-20   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.common.log;

import java.util.List;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import com.king.base.SpringContextHelper;

public class DesktopMethodBeforeAdvice implements MethodInterceptor {
	
	/**
	 * 在方法调用整个过程中。
	 * @param MethodInvocation 调用信息
	 * @return Object 方法返回值
	 * @throws Throwable 抛出例外时，将中止本操作.
	 */
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object[] args=invocation.getArguments();
		CacheManager manager = (CacheManager) SpringContextHelper.getBean("cacheManager");
    	Cache cache=manager.getCache("desktop");
    	String oldtime=null;
    	Object rval=null;
    	if(cache==null){
    		//获取客户端当前消息更新时间
    		int argsCount=args.length;
    		if(argsCount>0){
    			oldtime=args[0].toString().replaceAll("-", "").replaceAll(":", "").replaceAll(" ", "");
    		}
    		rval = invocation.proceed();
    	}else{
    		//获取客户端当前消息更新时间
    		int argsCount=args.length;
    		if(argsCount>0){
    			oldtime=args[0].toString().replaceAll("-", "").replaceAll(":", "").replaceAll(" ", "");
    		}
    		if(oldtime.equals("1")){
    			rval = invocation.proceed();
    		}else{
    			//获取cache中Lisener到jms发送来的新消息
    	        String newtime=null;
        		Element element = cache.get("newtime");
        		if(element!=null){
        			newtime=element.getValue().toString();
        			try{
            			long newLong=Long.parseLong(newtime);
            			long oldLong=Long.parseLong(oldtime);
            			long balance=newLong-oldLong;
            			if(balance>0){
//            				内存中已缓存的Element数量
//                	        long memoryStoreSize=cache.getMemoryStoreSize();
                	        //磁盘中已缓存的Element数量 
//                	        long diskStoreSize=cache.getDiskStoreSize();
                	        //模拟当前用户是admin
//                	        String role="admin";
                	        //遍历cache的算法（待优化）
//                	        List<String> keys = cache.getKeys();
//            				for (String key : keys) {
//            					System.out.println(key + "," + cache.get(key));
//            				}
                	        //根据角色和用户id将符合条件的消息返回给action（待解决）
            				
            				rval = invocation.proceed();
            			}
            		}catch(Exception e){
            			rval = invocation.proceed();
            		}
        		}
    		}
    	}
    	return rval;
	}
	
}
