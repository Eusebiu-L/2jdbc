package ro.emanuel.tema.dao.pojo;

public class RubikCube {

	private int id;
	private String brand;
	private double weight;
	private int sides;

	public RubikCube (int id, String brand, double weight, int sides) {
		this.id = id;
		this.brand = brand;
		this.weight = weight;
		this.sides = sides;
	}

	public int getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public double getWeight() {
		return weight;
	}

	public int getSides() {
		return sides;
	}
}
