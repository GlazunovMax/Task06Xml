package by.epam.javawebtraining.glazunov.task06.saxparser;

import java.io.IOException;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.epam.javawebtraining.glazunov.task06.entity.Train;

public class SaxParser {

	public static void main(String[] args) throws SAXException, IOException {
		XMLReader reader = XMLReaderFactory.createXMLReader();
		
		TrainSaxHandler handler = new TrainSaxHandler();
		
		reader.setContentHandler(handler);
		
		reader.parse(new InputSource("src/main/java/by/epam/javawebtraining/glazunov/task06/xml/trains.xml"));
		
		List<Train> trains = handler.getTrainList();
		
		for (Train train : trains) {
			System.out.println(train.toString());
		}
	}

}
