package ro.emanuel.tema.dao.pojo;

public class Computer {
	private int id;
	private String brand;
	private double price;
	private int stock;
	public Computer(int id, String brand, double price, int stock) {
		super();
		this.id = id;
		this.brand = brand;
		this.price = price;
		this.stock = stock;
	}
	public int getId() {
		return id;
	}
	public String getBrand() {
		return brand;
	}
	public double getPrice() {
		return price;
	}
	public int getStock() {
		return stock;
	}
	
	

}
