package by.epam.javawebtraining.glazunov.task06.staxparser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.epam.javawebtraining.glazunov.task06.entity.Locomotive;
import by.epam.javawebtraining.glazunov.task06.entity.LocomotiveType;
import by.epam.javawebtraining.glazunov.task06.entity.LuggageWaggon;
import by.epam.javawebtraining.glazunov.task06.entity.PassengerWaggon;
import by.epam.javawebtraining.glazunov.task06.entity.PassengerWaggonType;
import by.epam.javawebtraining.glazunov.task06.entity.Train;

public class StAXParser {

	public static void main(String[] args) throws FileNotFoundException {
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();

		try {
			InputStream inputStream = new FileInputStream(
					"src/main/java/by/epam/javawebtraining/glazunov/task06/xml/trains.xml");
			XMLStreamReader reader = inputFactory.createXMLStreamReader(inputStream);

			List<Train> trainList = process(reader);

			for (Train train : trainList) {
				System.out.println(train.toString());
			}

		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}

	
	
	
	private static List<Train> process(XMLStreamReader reader) throws XMLStreamException {
		List<Train> trainList = new ArrayList<Train>();
		Train train = null;

		List<Locomotive> locomotiveList = new ArrayList<Locomotive>();
		Locomotive locomotive = null;

		List<PassengerWaggon> passengerWaggonList = new ArrayList<PassengerWaggon>();
		PassengerWaggon passengerWaggon = null;

		List<LuggageWaggon> luggageWaggonList = new ArrayList<LuggageWaggon>();
		LuggageWaggon luggageWaggon = null;

		TrainTagName elememtName = null;

		while (reader.hasNext()) {// есть ли следующий узел в хml документе

			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:

				elememtName = TrainTagName.getElementTagName(reader.getLocalName());
				
				switch (elememtName) {
				case TRAIN:
					train = new Train();
					Integer id = Integer.parseInt(reader.getAttributeValue(null, "id"));
					train.setId(id);
					break;
				case LOCOMOTIVE:
					locomotive = new Locomotive();
					Double lenghtLoc = Double.parseDouble(reader.getAttributeValue(null, "lenght"));
					locomotive.setLenght(lenghtLoc);
					break;
				case PASSENGER_WAGGON:
					passengerWaggon = new PassengerWaggon();
					Double lenghtPasWag = Double.parseDouble(reader.getAttributeValue(null, "lenght"));
					passengerWaggon.setLenght(lenghtPasWag);
					break;
				case LUGGAGE_WAGGON:
					luggageWaggon = new LuggageWaggon();
					Double lenghtLugWag = Double.parseDouble(reader.getAttributeValue(null, "lenght"));
					luggageWaggon.setLenght(lenghtLugWag);
					break;
				default: break;
				}
				break;

			case XMLStreamConstants.CHARACTERS:
				String text = reader.getText().trim();

				if (text.isEmpty()) {
					break;
				}

				switch (elememtName) {
				case NAME:
					train.setName(text);
					break;
				case SPEED:
					train.setSpeed(Integer.parseInt(text));
					break;
				case MARK:
					locomotive.setMark(text);
					break;
				case EFFICIENCY:
					locomotive.setEfficiency(Double.parseDouble(text));
					break;
				case LOCOMOTIVE_TYPE:
					locomotive.setLocomotiveType(LocomotiveType.valueOf(text.toUpperCase().replaceAll("-","_")));
					break;
				case NUMBER_SEAT:
					passengerWaggon.setNumberSeat(Integer.parseInt(text));
					break;
				case PASSENGER_WAGGON_TYPE:
					passengerWaggon.setPassengerWaggonType(PassengerWaggonType.valueOf(text.toUpperCase().replaceAll("-","_")));
					break;
				case WEIGHT:
					luggageWaggon.setWeight(Double.parseDouble(text));
					break;
				default: break;
				}
				break;
				
			case XMLStreamConstants.END_ELEMENT:
				elememtName = TrainTagName.getElementTagName(reader.getLocalName());
				switch (elememtName) {
				case LOCOMOTIVE:
					locomotiveList.add(locomotive);
					break;
				case PASSENGER_WAGGON:
					passengerWaggonList.add(passengerWaggon);
					break;
				case LUGGAGE_WAGGON:
					luggageWaggonList.add(luggageWaggon);
					break;
				case TRAIN:
					train.setLocomotives(locomotiveList);
					train.setPassengerWaggons(passengerWaggonList);
					train.setLuggageWaggons(luggageWaggonList);
					
					trainList.add(train);
					
					locomotiveList = new ArrayList<>();
					passengerWaggonList = new ArrayList<>();
					luggageWaggonList = new ArrayList<>();
					
					break;
				default: break;
				}
			}

		}
		return trainList;

	}

}
