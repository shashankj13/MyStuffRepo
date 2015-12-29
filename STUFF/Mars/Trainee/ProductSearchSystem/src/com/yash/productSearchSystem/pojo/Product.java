package com.yash.productSearchSystem.pojo;


public class Product {
	
	private String productItems;
	private String vendor;
	private String city;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((productItems == null) ? 0 : productItems.hashCode());
		result = prime * result + ((vendor == null) ? 0 : vendor.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (productItems == null) {
			if (other.productItems != null)
				return false;
		} else if (!productItems.equals(other.productItems))
			return false;
		if (vendor == null) {
			if (other.vendor != null)
				return false;
		} else if (!vendor.equals(other.vendor))
			return false;
		return true;
	}
	public Product(String productItems, String vendor, String city) {
		this.productItems=productItems;
		this.vendor=vendor;
		this.city=city;
	}
	public String getProductItems() {
		return productItems;
	}
	public void setProductItems(String productItems) {
		this.productItems = productItems;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

}
