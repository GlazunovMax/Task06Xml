package by.epam.javawebtraining.glazunov.task06.saxparser;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.epam.javawebtraining.glazunov.task06.entity.Locomotive;
import by.epam.javawebtraining.glazunov.task06.entity.LocomotiveType;
import by.epam.javawebtraining.glazunov.task06.entity.LuggageWaggon;
import by.epam.javawebtraining.glazunov.task06.entity.PassengerWaggon;
import by.epam.javawebtraining.glazunov.task06.entity.PassengerWaggonType;
import by.epam.javawebtraining.glazunov.task06.entity.Train;

public class TrainSaxHandler extends DefaultHandler {
	private List<Train> trainList = new ArrayList<Train>();
	private Train train;

	private List<Locomotive> locomotiveList = new ArrayList<Locomotive>();
	private Locomotive locomotive;

	private List<PassengerWaggon> passengerWaggonList = new ArrayList<PassengerWaggon>();
	private PassengerWaggon passengerWaggon;

	private List<LuggageWaggon> luggageWaggonList = new ArrayList<LuggageWaggon>();
	private LuggageWaggon luggageWaggon;

	private StringBuilder text;

	public List<Train> getTrainList() {
		return trainList;
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Parsing started");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("Parsing ended");
	}

	@Override
	public void characters(char[] buffer, int start, int length) throws SAXException {
		text.append(buffer, start, length);
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		text = new StringBuilder();
		
		if (qName.equals("train")) {
			train = new Train();
			train.setId(Integer.parseInt(attributes.getValue("id")));
		}

		if (qName.equals("locomotive")) {
			locomotive = new Locomotive();
			locomotive.setLenght(Double.parseDouble(attributes.getValue("lenght")));
		}

		if (qName.equals("passenger-waggon")) {
			passengerWaggon = new PassengerWaggon();
			passengerWaggon.setLenght(Double.parseDouble(attributes.getValue("lenght")));
		}

		if (qName.equals("luggage-waggon")) {
			luggageWaggon = new LuggageWaggon();
			luggageWaggon.setLenght(Double.parseDouble(attributes.getValue("lenght")));
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		TrainTagName tagName = TrainTagName.valueOf(qName.toUpperCase().replace("-", "_"));

		switch (tagName) {
		case NAME: train.setName(text.toString()); break;
		case SPEED: train.setSpeed(Integer.parseInt(text.toString())); break;
		
		case MARK: locomotive.setMark(text.toString()); break;
		case EFFICIENCY: locomotive.setEfficiency(Double.parseDouble(text.toString())); break;
		case LOCOMOTIVE_TYPE: locomotive.setLocomotiveType(LocomotiveType.valueOf(text.toString().toUpperCase())); break;
		case LOCOMOTIVE: locomotiveList.add(locomotive); break;

		case NUMBER_SEAT: passengerWaggon.setNumberSeat(Integer.parseInt(text.toString())); break;
		case PASSENGER_WAGGON_TYPE:
			passengerWaggon.setPassengerWaggonType(PassengerWaggonType.valueOf(text.toString().toUpperCase().replace("-", "_")));
			break;
		case PASSENGER_WAGGON: passengerWaggonList.add(passengerWaggon); break;

		case WEIGHT: luggageWaggon.setWeight(Double.parseDouble(text.toString())); break;
		case LUGGAGE_WAGGON: luggageWaggonList.add(luggageWaggon); break;

		case TRAIN:
			train.setLocomotives(locomotiveList);
			train.setPassengerWaggons(passengerWaggonList);
			train.setLuggageWaggons(luggageWaggonList);
			
			trainList.add(train);
			locomotiveList = new ArrayList<>();
			passengerWaggonList = new ArrayList<>();
			luggageWaggonList = new ArrayList<>();
			
			train = null;
			break;

		default: break;
		}

	}

}
