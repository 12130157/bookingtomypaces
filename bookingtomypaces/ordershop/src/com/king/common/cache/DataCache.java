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
import java.util.TreeMap;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.king.common.exception.KINGException;
import com.king.common.xml.XMLDataBean;

public class DataCache extends PublicCache {

	/**
	 * 代理例外字典的内部类
	 * 
	 * @author lishan
	 */
	class DataDicModel extends XMLDataBean {
		
	
		private static final long serialVersionUID = 1L;

		/**
		 * 节点解析
		 */
		public void expandElementNode(Element node, Object parent) {
			String tag = node.getTagName();
			// System.out.println("datadic:"+tag);
			if (tag.equals("datadic")) {
				parseChildNodes(node, null);
			} else if (tag.equals("section")) {
				parseChildNodes(node, null);
			} else if (tag.equals("attr")) {
				String code = node.getAttribute("code");
				java.util.TreeMap<Object,Object> attr = new java.util.TreeMap<Object,Object>();
				cacheInstance.put(code, attr);
				parseChildNodes(node, attr);
			} else if (tag.equals("item")) {
				String code1 = node.getAttribute("code");
				String name1 = node.getAttribute("name");
				// System.out.println("code1:"+code1);
				((java.util.TreeMap<Object,Object>) parent).put(code1, name1);
			}
		}

		/**
		 * 属性扩展。
		 */
		public void expandAttributeNode(Attr attr) {
		}
	}

	/**
	 * ErrorDic 构造子注解。
	 */
	public DataCache() {
		super();

	}

	/**
	 * 完成cache的初始化。
	 * 
	 * @throw 从文件中装载cache时例外
	 */
	public void loadFromFile() throws KINGException {
		DataDicModel model = new DataDicModel();
		model.setXMLFile(curCacheFile);

		model.parseFromXML();
		fileDomMapping.put(curCacheFile, model);
		CacheUtil.dataCache = this;
	}

	/**
	 * 将cache中数据保存到cache文件中。
	 * 
	 * @throws  将cache保存到文件时例外
	 */
	public void saveCache() throws KINGException {
		DataDicModel model = new DataDicModel();
		model.setXMLFile(curCacheFile);
		model.saveToXML();
	}
	
	/**
	 * 动态的更新cache的值，如果value为null,那么从cache中清除掉key对应项;如果key不存在，那么就添加新数据项;如果key已经存在，那么就更新数据。
	 * 
	 * @param key
	 *            需要更新的key。
	 * @param value
	 *            需要更新的值。
	 */
	public void updateCache(String key, Object value, String fileName) {
		if (key == null) {
			// 此处记录警告信息，
			
			return;
		}

		// 此处要求更新dom，进而更新配置文件。
		if (fileName == null || fileName.trim().length() == 0) {
			fileName = keyFileMapping.get(key);
		}
		// 如果仍然没有fileName,那么抛出错误信息返回
		if (fileName == null || fileName.trim().length() == 0) {
			return;
		}

		// 获得对应的Dom
		XMLDataBean bean = fileDomMapping.get(fileName);
		Document dom = bean.getDom();
		NodeList nodes = dom.getElementsByTagName("attr");
		boolean isNew = true;
		int nodeNumber = nodes.getLength();
		for (int i = 0; i < nodeNumber; i++) {
			Element node = (Element) nodes.item(i);
			String targetKey = node.getAttribute("code");
			if (targetKey.equals(key)) {
				if (value != null) {
					// 如果有节点，清除所有子节点，重新添加
					NodeList children = node.getChildNodes();
					int childNum = children.getLength();
					//System.out.println(node);
					for(int cn=0;cn<childNum;cn++){
						Node child = children.item(cn);
						if(child!=null)
						node.removeChild(child);
					}
					//以下添加新值
					Map vMap = (Map)value;
					Object[] keys=vMap.keySet().toArray();
					for(int cn=0;cn<keys.length;cn++){
						Element ne=dom.createElement("item");
						
						ne.setAttribute("code", (String)keys[cn]);
						ne.setAttribute("name",(String)vMap.get(keys[cn]));
						node.appendChild(ne);
					}
					
				} else {
					// 如果值为空，那么删除该节点,此处有系统例外。
					try {
						//如何去掉dom中一个节点呢，告诉不存在
						node.getParentNode().removeChild(node);
						//dom.removeChild(node);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				isNew = false;
				break;
			}

		}
		// 如果没有找到节点那么当成添加。
		if (isNew) {
			// 此处添加新节点
			Element newNode = dom.createElement("attr");
			newNode.setAttribute("code", key);
			newNode.setAttribute("name", key);
			
			Map vMap = (Map)value;
			Object[] keys=vMap.keySet().toArray();
			for(int cn=0;cn<keys.length;cn++){
				Element ne=dom.createElement("item");
				ne.setAttribute("code", (String)keys[cn]);
				ne.setAttribute("name",(String)vMap.get(keys[cn]));
				newNode.appendChild(ne);
			}
			dom.getDocumentElement().appendChild(newNode);
		}
		// 此处立即保存文件
		try {
			bean.saveToXML();
			super.updateCache(key, value);
		} catch (KINGException ex) {
			
			ex.printStackTrace();
		}
	}

	/**
	 * 返回数据字典中对应的配置项。
	 * 
	 * @param dataName
	 *            数据项名称
	 * @return TreeMap实例 dataName对应的配置项
	 */
	public TreeMap<Object,Object> getDataMap(String dataName) {
		TreeMap<Object,Object> rv = (TreeMap<Object,Object>) cacheInstance.get(dataName);
		if(rv==null)rv = new TreeMap();
		return rv;
	}
	/**
	 * 获取dataName对应的cache实例，并且将cache值转换为json格式
	 * @param dataName
	 * @return String JSON格式的字符串数组
	 */
	public String getDataString(String dataName){
		TreeMap<Object,Object> map = this.getDataMap(dataName);
		
		Object[] keys = map.keySet().toArray();
		Object value;
		
		String entry;
		StringBuffer data = new StringBuffer();
		for(Object key:keys){
			value = map.get(key);
			if(data.toString().length()>0){
				data.append(",").append("['").append(key).append("'").append(",").append("'").append(value).append("']");
			}
			else {
				
				data.append("[").append("['").append(key).append("'").append(",").append("'").append(value).append("']");
			}
		}
		data.append("]");
		return data.toString();
	}
	/**
	 * 获得系统所有的cache名称
	 * @return Cache名称数组
	 */
	public Object[] getCacheNames(){
		Object[] keys = cacheInstance.keySet().toArray();
		return keys;
	}
}

