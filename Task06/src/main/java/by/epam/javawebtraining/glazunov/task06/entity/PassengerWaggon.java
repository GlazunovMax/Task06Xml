package by.epam.javawebtraining.glazunov.task06.entity;

public class PassengerWaggon {
	private double lenght;
	private int numberSeat;
	private PassengerWaggonType passengerWaggonType;

	public int getNumberSeat() {
		return numberSeat;
	}

	public void setNumberSeat(int numberSeat) {
		this.numberSeat = numberSeat;
	}

	public PassengerWaggonType getPassengerWaggonType() {
		return passengerWaggonType;
	}

	public void setPassengerWaggonType(PassengerWaggonType passengerWaggonType) {
		this.passengerWaggonType = passengerWaggonType;
	}

	public double getLenght() {
		return lenght;
	}

	public void setLenght(double lenght) {
		this.lenght = lenght;
	}

	@Override
	public String toString() {
		return "PassengerWaggon [lenght=" + lenght + ", numberSeat=" + numberSeat + ", passengerWaggonType="
				+ passengerWaggonType + "]";
	}

}
