package com.vmchalla.XmlParseTest.service;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.vmchalla.XmlParseTest.bean.Family;
import com.vmchalla.XmlParseTest.bean.Member;

/**
 * This Class handles the call back events for our SAX parsing
 * @author Vmchalla
 *
 */
public class SaxHandler extends DefaultHandler {
	private Family familyTree = null;
	private Member member = null;
	private boolean bAge = false;
    private boolean bName = false;
    private boolean bRole = false;
	
	public Family getFamilyTree(){
		return this.familyTree;
	}
	
	@Override
	public void startElement (String uri, String localName,String qName, Attributes attributes) 
			throws SAXException{
		if (qName.equalsIgnoreCase("member")){
			String type = attributes.getValue("type");
			member=new Member();
			member.setRelationToFamilyHead(type);
			if(familyTree==null){
				familyTree = new Family();
			}
			
		} else if (qName.equalsIgnoreCase("name")){
			bName=true;
		} else if(qName.equalsIgnoreCase("age")){
			bAge=true;
		} else if(qName.equalsIgnoreCase("occupation")){
			bRole=true;
		}
		
	}
	
	@Override
    public void characters(char ch[], int start, int length) throws SAXException {
		if(bName){
			member.setName(new String(ch, start, length));
			bName=false;
		} else if(bAge){
			member.setAge(Integer.parseInt(new String(ch, start, length)));
			bAge=false;
		} else if(bRole){
			member.setOccupation(new String(ch, start, length));
			bRole=false;
		}
		
	}
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("member")){
			familyTree.addMember(member);
		}
	}
	
	

}
