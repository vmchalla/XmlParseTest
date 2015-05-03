package com.vmchalla.XmlParseTest;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import com.vmchalla.XmlParseTest.bean.Family;
import com.vmchalla.XmlParseTest.service.DomService;
import com.vmchalla.XmlParseTest.service.SaxService;

/**
 * This class has the main stub where we call the parsers and show the data to the user.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // initialize and call the DOM parser
    	System.out.println("----------------Family Tree using DOM Parser----------------------");
    	DomService dom = new DomService();
    	try {
			Family family=dom.getFamilyTree();
			System.out.println(family.toString());
		} catch (XPathExpressionException e) {
			System.out.println("Xpath Expression fault Please check: "+e.getMessage());
		} catch (SAXException e) {
			System.out.println("SAX fault Please check: "+e.getMessage());
		} catch (IOException e) {
			System.out.println("IO Exception: fault Please check: "+e.getMessage());
		} catch (ParserConfigurationException e) {
			System.out.println("Parse Configuration fault Please check: "+e.getMessage());
		}
    	System.out.println("--------------------------------------------------------------------");
    	//Initialize and call the SAX parser
    	System.out.println("----------------Family Tree using SAX Parser----------------------");
    	SaxService sax = new SaxService();
    	try {
			Family familyTreeUsingSax = sax.getFamilyTree();
			System.out.println(familyTreeUsingSax.toString());
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException fault Please check: "+e.getMessage());
		} catch (ParserConfigurationException e) {
			System.out.println("Parser configuration fault Please check: "+e.getMessage());
		} catch (SAXException e) {
			System.out.println("SAX  fault Please check: "+e.getMessage());
		} catch (IOException e) {
			System.out.println("IOException fault Please check: "+e.getMessage());
		}
    	//Additional convert the XML file to JSONand create the JSON file.
    }
}
