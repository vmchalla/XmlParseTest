package com.vmchalla.XmlParseTest.service;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.vmchalla.XmlParseTest.AppUtil;
import com.vmchalla.XmlParseTest.bean.Family;
import com.vmchalla.XmlParseTest.bean.Member;

/**
 * This service class parses the XML file using the DOM parsing method using the XPath features.
 * @author Vmchalla
 *
 */
public class DomService {
	private static final String XML_NODENAME_NAME="name";
	private static final String XML_NODENAME_AGE = "age";
	private static final String XML_NODENAME_OCCUPATION = "occupation";
	private static final String XML_NODE_ATTRIBUTE = "type";
	
	public Family getFamilyTree() throws SAXException, IOException, ParserConfigurationException, XPathExpressionException{
		
		Family familyTree = new Family();
		Member familyHead = new Member();
		//get the Document 
		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(AppUtil.getFile());
		
		//Start Parsing and filling in the information into family tree.
		
		//Get the FamilyHead from the xml
		String expression = "/family/members/member[@type='family-head']";
		Node node = AppUtil.getNode(expression, document);
		if (null != node){
			NodeList headNodeList = node.getChildNodes();
			for(int i=0; null!=headNodeList && i<headNodeList.getLength();i++){
				Node valueNode = headNodeList.item(i);
				if(valueNode.getNodeType()==Node.ELEMENT_NODE){
					switch (valueNode.getNodeName()) {
					case XML_NODENAME_NAME:
						familyHead.setName(valueNode.getFirstChild().getNodeValue());
						break;
					case XML_NODENAME_AGE:
						familyHead.setAge(Integer.parseInt(valueNode.getFirstChild().getNodeValue()));
						break;
					case XML_NODENAME_OCCUPATION:
						familyHead.setOccupation(valueNode.getFirstChild().getNodeValue());
						break;

					default:
						break;
					}
				}
			}
			familyHead.setRelationToFamilyHead("Self");
		}
		//System.out.println(familyHead.toString());
		boolean isFamilyHeadAdded = familyTree.addMember(familyHead);
		//System.out.println("Family Head Added :"+isFamilyHeadAdded);
		expression = "/family/members/member[@type!='family-head']";
		NodeList otherFamilyMembers = AppUtil.getNodeList(expression, document);
		for(int i=0; null!=otherFamilyMembers && i<otherFamilyMembers.getLength();i++){
			Node memberNode = otherFamilyMembers.item(i);
			if(null != memberNode){
				Member otherMember = populateMember(memberNode);
				familyTree.addMember(otherMember);
			}
		}
		return familyTree;
	}
	
	private Member populateMember(Node memberNode){
		Member member = new Member();
		NodeList memberNodeList = memberNode.getChildNodes();
		for(int i=0; null!=memberNodeList && i<memberNodeList.getLength();i++){
			Node valueNode = memberNodeList.item(i);
			if(valueNode.getNodeType()==Node.ELEMENT_NODE){
				switch (valueNode.getNodeName()) {
				case XML_NODENAME_NAME:
					member.setName(valueNode.getFirstChild().getNodeValue());
					break;
				case XML_NODENAME_AGE:
					member.setAge(Integer.parseInt(valueNode.getFirstChild().getNodeValue()));
					break;
				case XML_NODENAME_OCCUPATION:
					member.setOccupation(valueNode.getFirstChild().getNodeValue());
					break;

				default:
					break;
				}
			}
			Element memberElement = (Element) memberNode;
			member.setRelationToFamilyHead(memberElement.getAttribute(XML_NODE_ATTRIBUTE));
		}
		return member;
	}

}
