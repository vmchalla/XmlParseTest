package com.vmchalla.XmlParseTest.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.vmchalla.XmlParseTest.AppUtil;
import com.vmchalla.XmlParseTest.bean.Family;

public class SaxService {
	
	public Family getFamilyTree() throws ParserConfigurationException, SAXException, FileNotFoundException, IOException{
		
		SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
		SaxHandler handler = new SaxHandler();
		saxParser.parse(AppUtil.getFile(), handler);
		Family familyTree = handler.getFamilyTree();
		return familyTree;
	}

}
