/*
 * David Keen
 * 1/31/20
 * CSCE 146H
 * Homework 01
 */
//Prize class for the ShowcaseGame, Prizes have a name and a price
public class Prize {
	private double price;
	private String name;
	
	public Prize() {
		this.price = 0.0;
		this.name="no name yet";
	}
	public Prize(double price, String name) {
		this.price = price;
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public String getName() {
		return name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
