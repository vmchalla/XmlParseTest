package com.vmchalla.XmlParseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.vmchalla.XmlParseTest.bean.Family;

/**
 * This Class holds the utility methods for the XmlParser App.
 * @author Vmchalla
 *
 */
public class AppUtil {
	
	private static XPath xPath = XPathFactory.newInstance().newXPath();
	
	/**
	 * Prints the family tree given the family object.
	 * @param familytree
	 */
	public static void print(Family familytree){
		
	}
	
	public static FileInputStream getFile() throws FileNotFoundException{
		return new FileInputStream("/Users/Pandu/Documents/JavaWorks/workspace/XmlParseTest/src/main/resources/family.xml");
	}
	
	public static String getValue(String expression, Document xmlDocument) throws XPathExpressionException{
		return xPath.compile(expression).evaluate(xmlDocument);
	}
	
	public static Node getNode(String expression, Document xmlDocument) throws XPathExpressionException{
		return (Node) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODE);
	}
	
	public static NodeList getNodeList(String expression, Document xmlDocument) throws XPathExpressionException{
		return (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
	}
	
	

}
