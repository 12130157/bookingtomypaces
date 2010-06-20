/**    
* 
* 版本信息：   
* 日期：2010-4-20   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.common.cache;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.king.common.exception.IKINGException;
import com.king.common.exception.KINGError;
import com.king.common.exception.KINGException;
import com.king.common.xml.XMLDataBean;

public class ExceptionCache extends PublicCache {

	ErrorDicModel errorDic = null;

	class ErrorDicModel extends XMLDataBean {

		private static final long serialVersionUID = 1L;

		public void expandElementNode(Element node, Object parent) {
			String tag = node.getTagName();
			if (tag.equals("errordic")) {
				parseChildNodes(node, null);
			} else if (tag.equals("section")) {
				parseChildNodes(node, null);
			} else if (tag.equals("item")) {
				String code = node.getAttribute("code");
				keyFileMapping.put(code, curCacheFile);
				String name = node.getAttribute("name");
				String cause = node.getAttribute("cause");
				String solution = node.getAttribute("solution");
				String type= node.getAttribute("type");
				if(type!=null && type.equals("error")){
					KINGError ex = new KINGError(code, cause, name,
							solution);
					cacheInstance.put(code, ex);
				}
				else{
					KINGException ex = new KINGException(code, cause, name,
						solution);
					cacheInstance.put(code, ex);
				}
				
			}
		}

		public void expandAttributeNode(Attr attr) {
		}
	}

	public ExceptionCache() {
		super();
	}

	public void loadFromFile() throws KINGException {

		errorDic = new ErrorDicModel();
		errorDic.setXMLFile(curCacheFile);
		errorDic.parseFromXML();
		fileDomMapping.put(curCacheFile, errorDic);
		CacheUtil.errorCache = this;
		// LogUtil.info("KING", "Error cache init[" + curCacheFile +
		// "],success");
	}

	public void saveCache() throws KINGException {
		errorDic.saveToXML();
	}
	
	public void updateCache(String key,Object value){
		super.updateCache(key,value);
		Element elmt = errorDic.getDom().getDocumentElement();
		Element newChild =errorDic.getDom().createElement("item");
		IKINGException ex = (IKINGException)value;
		newChild.setAttribute("code",ex.getErrorCode());
		newChild.setAttribute("name",ex.getErrorName());
		newChild.setAttribute("cause",ex.getErrorCause());
		newChild.setAttribute("solution",ex.getErrorSolution());
		elmt.appendChild(newChild);
	}
	
	public void updateCache(String key, Object value, String fileName) {
		if (key == null) {
//			LogUtil.warn("DB", "");
			return;
		}

		if (fileName == null || fileName.trim().length() == 0) {
			fileName = keyFileMapping.get(key);
		}
		if (fileName == null || fileName.trim().length() == 0) {
//			LogUtil.error("DB","" + key +""
//					+ fileName);
			return;
		}

		XMLDataBean bean = fileDomMapping.get(fileName);
		System.out.print("bean:"+bean);
		Document dom = bean.getDom();
		NodeList nodes = dom.getElementsByTagName("item");
		boolean isNew = true;
		int nodeNumber = nodes.getLength();
		for (int i = 0; i < nodeNumber; i++) {
			Element node = (Element) nodes.item(i);
			String targetKey = node.getAttribute("code");
			if (targetKey.equals(key)) {
				if (value != null) {
					KINGException ex = (KINGException)value;
					node.setAttribute("code",ex.getErrorCode());
					node.setAttribute("name",ex.getErrorName());
					node.setAttribute("cause",ex.getErrorCause());
					node.setAttribute("solution",ex.getErrorSolution());
				} else {
					try {
						node.getParentNode().removeChild(node);
						
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				isNew = false;
				break;
			}

		}
		if (isNew) {
			Element newNode = dom.createElement("item");
			KINGException ex = (KINGException)value;
			newNode.setAttribute("code",ex.getErrorCode());
			newNode.setAttribute("name",ex.getErrorName());
			newNode.setAttribute("cause",ex.getErrorCause());
			newNode.setAttribute("solution",ex.getErrorSolution());
			dom.getDocumentElement().appendChild(newNode);
		}
		try {
			bean.saveToXML();
			super.updateCache(key, value);
		} catch (KINGException ex) {
//			LogUtil.warn("FILE", "" + bean.getXMLFile() + "");
			ex.printStackTrace();
		}

	}
	
	public KINGException getException(String errorCode) {
		Object exceptionObj = cacheInstance.get(errorCode);
		if(exceptionObj!=null && exceptionObj instanceof KINGException){
			KINGException rv = (KINGException) exceptionObj;
			return rv;
		}
		else
			return null;
		
	}
	
	public KINGError getError(String errorCode) {
		Object exceptionObj = cacheInstance.get(errorCode);
		if(exceptionObj!=null && exceptionObj instanceof KINGError){
			KINGError rv = (KINGError) exceptionObj;
			return rv;
		}
		else
			return null;
	}
}