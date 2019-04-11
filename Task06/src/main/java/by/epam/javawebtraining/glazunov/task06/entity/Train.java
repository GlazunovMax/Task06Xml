package by.epam.javawebtraining.glazunov.task06.entity;

import java.util.List;


public class Train {
	private int id;
	private String name;
	private int speed;
	private List<Locomotive> locomotives;
	private List<PassengerWaggon> passengerWaggons;
	private List<LuggageWaggon> luggageWaggons;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public List<Locomotive> getLocomotives() {
		return locomotives;
	}

	public void setLocomotives(List<Locomotive> locomotives) {
		this.locomotives = locomotives;
	}

	public List<PassengerWaggon> getPassengerWaggons() {
		return passengerWaggons;
	}

	public void setPassengerWaggons(List<PassengerWaggon> passengerWaggons) {
		this.passengerWaggons = passengerWaggons;
	}

	public List<LuggageWaggon> getLuggageWaggons() {
		return luggageWaggons;
	}

	public void setLuggageWaggons(List<LuggageWaggon> luggageWaggons) {
		this.luggageWaggons = luggageWaggons;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("Train : \n");

		builder.append("id = " + id).append("\n").append("name = " + name).append("\n")
				.append("speed = " + speed).append("\n").append("locomotives = " + locomotives).append("\n")
				.append("passengerWaggons = " + passengerWaggons).append("\n").append("luggageWaggons = " + luggageWaggons).append("\n");

		return builder.toString();

		/*
		 * return "Train [id=" + id + ", name=" + name + ", speed=" + speed +
		 * ", locomotives=" + locomotives + ", passengerWaggons=" + passengerWaggons +
		 * ", luggageWaggons=" + luggageWaggons + "]";
		 */
	}

	// get set
}
