/**    
* 
* 版本信息：   
* 日期：2010-4-20   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.common.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import com.sun.org.apache.xerces.internal.dom.DeferredDocumentImpl;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.king.common.exception.KINGException;

public abstract class XMLDataBean implements Serializable {

	private String filePath = null;

	private Document dom;

	public XMLDataBean() {
	}

	public String getXMLFile() {
		return filePath;
	}

	public String getContent() {
		return null;
	}

	public Document getDom() {
		return this.dom;
	}

	protected abstract void expandAttributeNode(org.w3c.dom.Attr node);

	protected abstract void expandElementNode(org.w3c.dom.Element node, Object parent);

	protected void parseChildNodes(org.w3c.dom.Node node, Object parent) {
		NodeList children = node.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {

			Node nodei = children.item(i);
			parseFromNode(nodei, parent);
		}
	}

	protected void parseFromNode(org.w3c.dom.Node node, Object parent) {
		if (node == null)
			return;
		int nodeType = node.getNodeType();
		switch (nodeType) {
		case Node.ATTRIBUTE_NODE:
			expandAttributeNode((Attr) node);
			break;
		case Node.ELEMENT_NODE:
			// System.out.println("nodei:"+((Element)node).getNodeName());
			expandElementNode((Element) node, parent);
			break;
		default:
			break;
		}
	}

	public void parseFromXML() throws KINGException {
		try {
			dom = getDom(filePath, false);
		} catch (java.io.IOException ex1) {
			ex1.printStackTrace();
			throw new KINGException(ex1);
		} catch (org.xml.sax.SAXException ex2) {
			ex2.printStackTrace();
			throw new KINGException(ex2);
		} catch (ParserConfigurationException ex3) {
			throw new KINGException(ex3);
		}

		parseFromNode(dom.getFirstChild(), null);
	}

	public void saveToXML() throws KINGException {
		FileOutputStream writer = null;
		try {
			writer = new FileOutputStream(filePath);
			Element root = dom.getDocumentElement();
			((DeferredDocumentImpl) dom).setXmlEncoding("UTF-8");
			((DeferredDocumentImpl) dom).setXmlVersion("1.0");
			String rv = ((DeferredDocumentImpl) dom).saveXML(root);
			int index = rv.indexOf("<paradic>");
			if (index < 0) {
				index = rv.indexOf("<errordic>");
			}
			if (index < 0) {
				index = rv.indexOf("<vos>");
			}
			if (index < 0) {
				index = rv.indexOf("<datadic>");
			}
			if (index < 0) {
				index = rv.indexOf("<dbdic>");
			}
			if (index < 0) {
				index = rv.indexOf("<web-app>");
			}
			if (index < 0) {
				index = rv.indexOf("<decorators");
			}
			String content = rv.substring(index);
			rv = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + content;
			writer.write(rv.getBytes("UTF-8"));
		} catch (java.io.IOException ex) {
			throw new KINGException(ex);
		}

		try {
			writer.close();
		} catch (java.io.IOException ex2) {
			throw new KINGException(ex2);
		}
	}

	public void setXMLFile(String xmlFile) {
		this.filePath = xmlFile;
	}

	private Document getDom(String filename, boolean validating) throws ParserConfigurationException, IOException, SAXException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(validating);
		Document doc = factory.newDocumentBuilder().parse(new File(filename));
		return doc;
	}

}
