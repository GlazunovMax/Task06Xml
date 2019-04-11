package by.epam.javawebtraining.glazunov.task06.staxparser;

public enum TrainTagName {
	TRAINS,	NAME, SPEED, LOCOMOTIVE, MARK, EFFICIENCY, LOCOMOTIVE_TYPE,	
	PASSENGER_WAGGON, NUMBER_SEAT, PASSENGER_WAGGON_TYPE, 
	LUGGAGE_WAGGON, WEIGHT, TRAIN;
	
	public static TrainTagName getElementTagName(String element) {
		switch (element) {
		case "trains": return TRAINS;
		case "name": return NAME;
		case "speed": return SPEED;
		case "locomotive": return LOCOMOTIVE;
		case "mark": return MARK;
		case "efficiency": return EFFICIENCY;
		case "locomotive-type": return LOCOMOTIVE_TYPE;
		case "passenger-waggon": return PASSENGER_WAGGON;
		case "number-seat": return NUMBER_SEAT;
		case "passenger-waggon-type": return PASSENGER_WAGGON_TYPE;
		case "luggage-waggon": return LUGGAGE_WAGGON;
		case "weight": return WEIGHT;
		case "train": return TRAIN;
		default:
			throw new EnumConstantNotPresentException(TrainTagName.class, element);
		}
		
	}
}
