package by.epam.javawebtraining.glazunov.task06.domparser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.epam.javawebtraining.glazunov.task06.entity.Locomotive;
import by.epam.javawebtraining.glazunov.task06.entity.LocomotiveType;
import by.epam.javawebtraining.glazunov.task06.entity.LuggageWaggon;
import by.epam.javawebtraining.glazunov.task06.entity.PassengerWaggon;
import by.epam.javawebtraining.glazunov.task06.entity.PassengerWaggonType;
import by.epam.javawebtraining.glazunov.task06.entity.Train;

public class DomTrainParser {

	public static void main(String[] args) throws SAXException, IOException {
		DOMParser parser = new DOMParser();
		parser.parse("src/main/java/by/epam/javawebtraining/glazunov/task06/xml/trains.xml");
		Document document = parser.getDocument();
		Element root = document.getDocumentElement(); // trains 
		
		List<Train> trainList = new ArrayList<>();
		NodeList trainNodes = root.getElementsByTagName("train");
		
		Train train = null;
		Locomotive locomotive = null;
		PassengerWaggon passengerWaggon = null;
		LuggageWaggon luggageWaggon = null;
		
		for (int i = 0; i < trainNodes.getLength(); i++) {
			train = new Train();
			
			Element trainElement = (Element) trainNodes.item(i);
			train.setId(Integer.parseInt(trainElement.getAttribute("id")));
			train.setName(getSingleChild(trainElement, "name").getTextContent().trim());
			train.setSpeed(Integer.parseInt(getSingleChild(trainElement, "speed").getTextContent().trim()));
			train.setLocomotives(parseGetLocomotive(trainElement, locomotive));
			train.setPassengerWaggons(parseGetPassengerWaggon(trainElement, passengerWaggon));
			train.setLuggageWaggons(parseGetLuggageWaggon(trainElement, luggageWaggon));
			trainList.add(train);
		}
		
		for (Train trainNew : trainList) {
			System.out.println(trainNew.toString());
		}
		
	}
	
	private static Element getSingleChild(Element element, String childName) {
		NodeList nodeList = element.getElementsByTagName(childName);
		Element child = (Element) nodeList.item(0);
		return child;
	}

	private static List<LuggageWaggon> parseGetLuggageWaggon(Element trainElement, LuggageWaggon luggageWaggon) {
		List<LuggageWaggon> luggageWaggonList = new ArrayList<>();
		NodeList luggageWaggonNodes = trainElement.getElementsByTagName("luggage-waggon");
		for (int j = 0; j < luggageWaggonNodes.getLength(); j++) {
			luggageWaggon = new LuggageWaggon();
			
			Element luggageWaggonElement = (Element) luggageWaggonNodes.item(j);
			luggageWaggon.setLenght(Double.parseDouble(luggageWaggonElement.getAttribute("lenght")));
			luggageWaggon.setWeight(Double.parseDouble(getSingleChild(luggageWaggonElement, "weight").getTextContent().trim()));
			
			luggageWaggonList.add(luggageWaggon);
			
		}
		return luggageWaggonList;
	}

	private static List<PassengerWaggon> parseGetPassengerWaggon(Element trainElement, PassengerWaggon passengerWaggon) {
		List<PassengerWaggon> passengerWaggonList = new ArrayList<>();
		NodeList passengerWaggonNodes = trainElement.getElementsByTagName("passenger-waggon");
		for (int j = 0; j < passengerWaggonNodes.getLength(); j++) {
			passengerWaggon = new PassengerWaggon();
			
			Element passengerWaggonElement = (Element) passengerWaggonNodes.item(j);
			passengerWaggon.setLenght(Double.parseDouble(passengerWaggonElement.getAttribute("lenght")));
			passengerWaggon.setNumberSeat(Integer.parseInt(getSingleChild(passengerWaggonElement, "number-seat").getTextContent().trim()));
			passengerWaggon.setPassengerWaggonType(PassengerWaggonType.valueOf(getSingleChild(passengerWaggonElement, "passenger-waggon-type").getTextContent().toUpperCase().replaceAll("-", "_").trim()));
			
			passengerWaggonList.add(passengerWaggon);
		}
		return passengerWaggonList;
	}

	private static List<Locomotive> parseGetLocomotive(Element trainElement, Locomotive locomotive) {
		List<Locomotive> locomotiveList = new ArrayList<>();
		NodeList locomotiveNodes = trainElement.getElementsByTagName("locomotive");
		for (int j = 0; j < locomotiveNodes.getLength(); j++) {
			locomotive = new Locomotive();
			
			Element locomotiveElement = (Element) locomotiveNodes.item(j);//getSingleChild(trainElement, "locomotive");//?
			locomotive.setLenght(Double.parseDouble(locomotiveElement.getAttribute("lenght")));
			locomotive.setMark(getSingleChild(locomotiveElement, "mark").getTextContent().trim());
			locomotive.setEfficiency(Double.parseDouble(getSingleChild(locomotiveElement, "efficiency").getTextContent().trim()));
			locomotive.setLocomotiveType(LocomotiveType.valueOf(getSingleChild(locomotiveElement, "locomotive-type").getTextContent().toUpperCase().replaceAll("-", "_").trim()));
			
			locomotiveList.add(locomotive);
	
		}
		return locomotiveList;
		
	}

	
}
