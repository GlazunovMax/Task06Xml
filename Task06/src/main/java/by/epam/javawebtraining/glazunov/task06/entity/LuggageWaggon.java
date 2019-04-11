package by.epam.javawebtraining.glazunov.task06.entity;

public class LuggageWaggon {
	private double weight;
	private double lenght;

	public double getLenght() {
		return lenght;
	}

	public void setLenght(double lenght) {
		this.lenght = lenght;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "LuggageWaggon [weight=" + weight + ", lenght=" + lenght + "]";
	}

}
