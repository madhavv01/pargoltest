package Assignment20;

//Assignment: Implementation of Part A Class
//Name : Madhav Jariwala
//Written by: (Madhav Jariwala - 2397671 AND Nupur Gupta - 2391212)

//General explanation:
//This program defines a Computer class with attributes such as brand, model, serial number, and price.
//The class includes constructors,Getters,Setters, a toString() method, and additional methods
//To find the number of created computers and compare objects for equality.

public class PartA{

	public class Computer { // Computer is the object
		private String brand; // these are attributes
		private String model;
		private long serialNumber;
		private double price;
		private static int numberOfCreatedComputers = 0;

		// Constructor
		public Computer(String br, String md, long sn, double pr) {
			brand = br;
			model = md;
			serialNumber = sn;
			price = pr;
			numberOfCreatedComputers++;
		}

		// Getter methods
		public String getBrand() {
			return brand;
		}

		public String getModel() {
			return model;
		}

		public long getserialNumber() {
			return serialNumber;
		}

		public double getPrice() {
			return price;
		}

		// Setter methods
		public void setBrand(String br) {
			brand = br;
		}

		public void setModel(String md) {
			model = md;
		}

		public void setserialNumber(long sn) {
			serialNumber = sn;
		}

		public void setPrice(double pr) {
			price = pr;
		}

		// Static method to find the number of created computers
		public static int findNumberOfCreatedComputers() {
			return numberOfCreatedComputers;
		}

		// toString method

		@Override
		public String toString() {
			return "Computer [brand=" + brand + ", model=" + model + ", serialNumber=" + serialNumber + ", price="
					+ price + "]";
		}

		public boolean equals(Computer c) {
			if (brand == c.brand && model == c.model && price == c.price) {
				return true;
			}

			else {
				return false;
			}

}}}