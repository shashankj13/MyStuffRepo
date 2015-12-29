package com.yash.builder;

public class Mobile {

	private Size size = new Size();
	private Brand brand = new Brand();
	private Price price = new Price();
	
	public Size getSize() {
		return size;
	}
	@Override
	public String toString() {
		return "Mobile [size=" + size.getInch() + ", brand=" + brand.getType() + ", price=" + price.getAmount() + "]";
	}
	public void setSize(Size size) {
		this.size = size;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public Price getPrice() {
		return price;
	}
	public void setPrice(Price price) {
		this.price = price;
	}
	
	
}
