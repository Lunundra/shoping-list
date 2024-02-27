package NewItem;

public class Item {
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getisKGorPice() {
		return isKGorPice;
	}

	public void setKGorPice(boolean isKGorPice) {
		this.isKGorPice = isKGorPice;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}
	
	public String getWeightUnit() {
		return weightUnit;
	}
	
	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getShop() {
		return shop;
	}

	public void setShop(String shop) {
		this.shop = shop;	
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}
	
	public String getSonderpreis() {
		return spezialPrice;
	}
	
	public void setSonderpreis(String spezialPrice) {
		this.spezialPrice = spezialPrice;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(Float price) {
		this.price = price;
	}
	

	
	int index;
	String name;
	boolean isKGorPice;
	double mass;
	String brand;
	String information;
	float price;
	String weightUnit;
	String shop;
	String spezialPrice;
	
	public Item(int index, String name,	boolean isKGorPice, double mass, String weightUnit, String brand, String shop, String information, String spezialPrice, float price) {
		
		this.index = index;
		this.name = name;
		this.isKGorPice = isKGorPice;
		this.mass = mass;
		this.brand = brand;
		this.shop = shop;
		this.information = information;	
		this.price = price;
		this.weightUnit = weightUnit;
		this.spezialPrice = spezialPrice;
	}
}


