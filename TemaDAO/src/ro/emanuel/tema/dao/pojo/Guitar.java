package ro.emanuel.tema.dao.pojo;

public class Guitar {
	private int id;
	private String brand;
	private double strings;
	private int number_strings;
	public Guitar(int id, String brand, double strings, int number_strings) {
		super();
		this.id = id;
		this.brand = brand;
		this.strings = strings;
		this.number_strings = number_strings;
	}
	public int getId() {
		return id;
	}
	public String getBrand() {
		return brand;
	}
	public double getStrings() {
		return strings;
	}
	public int getNumber_strings() {
		return number_strings;
	}
	
	
	
}
