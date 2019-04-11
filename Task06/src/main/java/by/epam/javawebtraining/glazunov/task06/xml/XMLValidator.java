package by.epam.javawebtraining.glazunov.task06.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XMLValidator {

	public static void main(String[] args) throws IOException {
		boolean valid = XMLValidator.checkXMLforXSD(
				"src/main/java/by/epam/javawebtraining/glazunov/task06/xml/trains.xml",
				"src/main/java/by/epam/javawebtraining/glazunov/task06/xml/trains.xsd");
		if (valid) {
			System.out.println("XML match XSD : " + valid);
		} else {
			System.out.println("XML not match XSD : " + valid);
		}

	}

	public static boolean checkXMLforXSD(String pathXml, String pathXsd) {
		try {
			File xml = new File(pathXml);
			File xsd = new File(pathXsd);

			if (!xml.exists()) {
				System.out.println("Not found Xml " + pathXml);
			}

			if (!xsd.exists()) {
				System.out.println("Not found Xsd " + pathXsd);
			}

			if (!xml.exists() || !xsd.exists()) {
				return false;
			}

			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

			Schema schema = factory.newSchema(xsd);

			Validator validator = schema.newValidator();

			validator.validate(new StreamSource(xml));

		} catch (IOException e) {
			System.out.println("IO " + e.getMessage());
			return false;
		} catch (SAXException e) {
			System.out.println("SAX " + e.getMessage());
			return false;
		}

		return true;
	}
}
