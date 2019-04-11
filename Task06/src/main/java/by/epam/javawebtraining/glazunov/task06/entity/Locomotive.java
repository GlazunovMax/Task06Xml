package by.epam.javawebtraining.glazunov.task06.entity;

public class Locomotive {
	private String mark;
	private double lenght;
	private double efficiency;
	private LocomotiveType locomotiveType;

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public double getLenght() {
		return lenght;
	}

	public void setLenght(double lenght) {
		this.lenght = lenght;
	}

	public double getEfficiency() {
		return efficiency;
	}

	public void setEfficiency(double efficiency) {
		this.efficiency = efficiency;
	}

	public LocomotiveType getLocomotiveType() {
		return locomotiveType;
	}

	public void setLocomotiveType(LocomotiveType locomotiveType) {
		this.locomotiveType = locomotiveType;
	}

	@Override
	public String toString() {
		return "Locomotive [mark=" + mark + ", lenght=" + lenght + ", efficiency=" + efficiency + ", locomotiveType="
				+ locomotiveType + "]";
	}

}
