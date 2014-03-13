package de.mylayout.tools;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Xml {
	
	public String getElement(String key)
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		Document doc = null;
		XPathFactory xPathfactory = null;
		XPath xpath = null;
		XPathExpression expr = null;
		NodeList nl = null;
		Node node = null;
		Element element = null;
		
		String home = null;

		xPathfactory = XPathFactory.newInstance();
		xpath = xPathfactory.newXPath();
		
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e2) {
			e2.printStackTrace();
		}
		
		try {
			doc = builder.parse("init.xml");
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}
		
		try {
			expr = xpath.compile("/root");
			 nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
		} catch (XPathExpressionException e1) {
			e1.printStackTrace();
		}
		
		for(int i=0; i<nl.getLength(); i++)
		{
			element = (Element)nl.item(i);
			node = ((Node)element.getElementsByTagName(key).item(0));
			home = node.getTextContent();
			
//			node = ((Node)element.getElementsByTagName("quelle").item(0));
//			quelle = node.getTextContent();
			
//			System.out.println("home->"+home);
		}
		
		return home;		
	}
	
//	private void energie()
//	{
//		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//		DocumentBuilder builder = null;
//		Document doc = null;
//		XPathFactory xPathfactory = null;
//		XPath xpath = null;
//		XPathExpression expr = null;
//
//		NodeList nl = null;
//		Node node = null;
//		Element element = null;
//		
//		String typ, quelle;
//		
//		xPathfactory = XPathFactory.newInstance();
//		xpath = xPathfactory.newXPath();
//
//		try {
//			builder = factory.newDocumentBuilder();
//		} catch (ParserConfigurationException e2) {
//			e2.printStackTrace();
//		}
//		
//		try {
//			doc = builder.parse("src/daten.xml");
//		} catch (SAXException | IOException e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			expr = xpath.compile("/hauptknoten/topic[@name='Energie']/content");
//			nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
//
//		} catch (XPathExpressionException e1) {
//			e1.printStackTrace();
//		}
//		
//		for(int i=0; i<nl.getLength(); i++)
//		{
//			element = (Element)nl.item(i);
//			node = ((Node)element.getElementsByTagName("typ").item(0));
//			typ = node.getTextContent();
//			
//			node = ((Node)element.getElementsByTagName("quelle").item(0));
//			quelle = node.getTextContent();
//			
//			System.out.println(typ+" -> "+quelle);
//		}
//		
//	}
//	
//	private void personen()
//	{
//		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//		DocumentBuilder builder = null;
//		Document doc = null;
//		XPathFactory xPathfactory = null;
//		XPath xpath = null;
//		XPathExpression expr = null;
//
//		NodeList nl = null;
//		Node node = null;
//		Element element = null;
//		
//		String name, alter, geschlecht;
//		
//		xPathfactory = XPathFactory.newInstance();
//		xpath = xPathfactory.newXPath();
//
//		 try {
//			builder = factory.newDocumentBuilder();
//		} catch (ParserConfigurationException e2) {
//			e2.printStackTrace();
//		}
//		
//		try {
//			doc = builder.parse("src/daten.xml");
//		} catch (SAXException | IOException e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			expr = xpath.compile("/hauptknoten/topic[@name='Personen']/person");
//			nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
//
//		} catch (XPathExpressionException e1) {
//			e1.printStackTrace();
//		}
//		
//		for(int i=0; i<nl.getLength(); i++)
//		{
//			element = (Element)nl.item(i);
//			
//			name = element.getTextContent();
//			alter = element.getAttribute("alter");
//			geschlecht = element.getAttribute("geschlecht");
//			
//			System.out.println(name+" -> "+alter+"Jahre -> "+geschlecht);
//		}
//		
//	}

	public static void main(String[] args) {


		new Xml();	// Konstruktor aufrufen
	}

}
