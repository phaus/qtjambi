package com.trolltech.unittests;

import static org.junit.Assert.*;

import com.trolltech.qt.core.QFile;
import com.trolltech.qt.core.QIODevice;
import com.trolltech.qt.xml.QXmlStreamReader;

public class TestXmlQXmlStreamReader {

	QXmlStreamReader xmlr;
	QFile xmlFile;
	QIODevice iod;
	
	@org.junit.BeforeClass
	public static void setUpClass() {
	}

	@org.junit.Before
	public void setUp() throws Exception {
		xmlFile = new QFile("classpath:com/trolltech/unittests/xmlSample1.xml");
		xmlr = new QXmlStreamReader();
	}

	@org.junit.After
	public void tearDown() throws Exception {
	}

	@org.junit.Test
	public void testQXmlStreamReader() {
		assertTrue(xmlFile.exists());
		QXmlStreamReader.TokenType token1 = xmlr.readNext();
		System.out.println(token1.name());
		QXmlStreamReader.TokenType token2 = xmlr.readNext();
		System.out.println(token2.name());
	}

}