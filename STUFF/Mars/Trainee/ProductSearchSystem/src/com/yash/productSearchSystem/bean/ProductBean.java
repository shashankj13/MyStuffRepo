package com.yash.productSearchSystem.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.yash.productSearchSystem.helper.SortByCity;
import com.yash.productSearchSystem.helper.SortByProduct;
import com.yash.productSearchSystem.helper.SortByVendor;
import com.yash.productSearchSystem.pojo.Product;

@ManagedBean
@SessionScoped
public class ProductBean {

	List<Product> listProduct = new ArrayList<>();

	public List<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}

	Set<String> productSet = new HashSet<>();
	Set<String> vendorSet = new HashSet<>();
	Set<String> citySet = new HashSet<>();
	private String productValue;
	private String vendorValue;
	private String citytValue;
	private String radioValue;
	private List<Product> outputList;

	public List<Product> getOutputList() {
		return outputList;
	}

	public void setOutputList(List<Product> outputList) {
		this.outputList = outputList;
	}

	public String getProductValue() {
		return productValue;
	}

	public void setProductValue(String productValue) {
		this.productValue = productValue;
	}

	public String getVendorValue() {
		return vendorValue;
	}

	public void setVendorValue(String vendorValue) {
		this.vendorValue = vendorValue;
	}

	public String getCitytValue() {
		return citytValue;
	}

	public void setCitytValue(String citytValue) {
		this.citytValue = citytValue;
	}

	public String getRadioValue() {
		return radioValue;
	}

	public void setRadioValue(String radioValue) {
		this.radioValue = radioValue;
	}

	public Set<String> getProductSet() {
		return productSet;
	}

	public void setProductSet(Set<String> productSet) {
		this.productSet = productSet;
	}

	public Set<String> getVendorSet() {
		return vendorSet;
	}

	public void setVendorSet(Set<String> vendorSet) {
		this.vendorSet = vendorSet;
	}

	public Set<String> getCitySet() {
		return citySet;
	}

	public void setCitySet(Set<String> citySet) {
		this.citySet = citySet;
	}


	@PostConstruct
	public void init() {

		listProduct.add(new Product("Mobile", "LG", "Indore"));
		listProduct.add(new Product("Mobile", "APPLE", "Indore"));
		listProduct.add(new Product("Mobile", "Samsung", "Pune"));
		listProduct.add(new Product("Mobile", "LG", "Mumbai"));
		listProduct.add(new Product("Mobile", "APPLE", "Mumbai"));
		listProduct.add(new Product("Mobile", "LG", "Mumbai"));
		listProduct.add(new Product("Mobile", "Samsung", "Indore"));
		listProduct.add(new Product("Mobile", "APPLE", "Delhi"));
		listProduct.add(new Product("Mobile", "LG", "Mumbai"));
		listProduct.add(new Product("Mobile", "LG", "Pune"));

		listProduct.add(new Product("Tv", "Samsung", "Indore"));
		listProduct.add(new Product("Tv", "Samsung", "Mumbai"));
		listProduct.add(new Product("Tv", "LG", "Delhi"));
		listProduct.add(new Product("Tv", "Micromax", "Indore"));
		listProduct.add(new Product("Tv", "Philips", "Pune"));
		listProduct.add(new Product("Tv", "Philips", "Indore"));
		listProduct.add(new Product("Tv", "LG", "Delhi"));
		listProduct.add(new Product("Tv", "Micromax", "Delhi"));
		listProduct.add(new Product("Tv", "Micromax", "Pune"));
		listProduct.add(new Product("Tv", "LG", "Indore"));
		listProduct.add(new Product("Tv", "LG", "Mumbai"));

		listProduct.add(new Product("Microwave", "LG", "Pune"));
		listProduct.add(new Product("Microwave", "Philips", "Indore"));
		listProduct.add(new Product("Microwave", "Samsung", "Mumbai"));
		listProduct.add(new Product("Microwave", "LG", "Indore"));
		listProduct.add(new Product("Microwave", "Philips", "Pune"));
		listProduct.add(new Product("Microwave", "LG", "Indore"));
		listProduct.add(new Product("Microwave", "Samsung", "Mumbai"));
		listProduct.add(new Product("Microwave", "Samsung", "Indore"));
		listProduct.add(new Product("Microwave", "Philips", "Delhi"));

		listProduct.add(new Product("Laptop", "Samsung", "Pune"));
		listProduct.add(new Product("Laptop", "Sony", "Mumbai"));
		listProduct.add(new Product("Laptop", "Samsung", "Indore"));
		listProduct.add(new Product("Laptop", "Sony", "Mumbai"));
		listProduct.add(new Product("Laptop", "APPLE", "Indore"));
		listProduct.add(new Product("Laptop", "APPLE", "Pune"));

		for (Product li : listProduct) {
			productSet.add(li.getProductItems());
			// System.out.println("SET OF PRODUCT VALUE : " + productSet);
			vendorSet.add(li.getVendor());
			// System.out.println("SET OF Vendor VALUE : " +setVendor);
			citySet.add(li.getCity());
			// System.out.println("SET OF City VALUE : " +setCity);
		}
	}

	public List<Product> getProductFromList() {
		outputList = new ArrayList<>();
		for (Product li : listProduct) {
			if (li.getCity().equalsIgnoreCase(this.citytValue) && li.getVendor().equalsIgnoreCase(this.vendorValue)
					&& li.getProductItems().equalsIgnoreCase(this.productValue)) {
				outputList.add(li);

			} else if (li.getCity().equalsIgnoreCase(this.citytValue)
					&& li.getVendor().equalsIgnoreCase(this.vendorValue) && this.productValue.equalsIgnoreCase("sel")) {
				outputList.add(li);
				
			} else if (li.getCity().equalsIgnoreCase(this.citytValue) && this.vendorValue.equalsIgnoreCase("sel")
					&& this.productValue.equalsIgnoreCase("sel")) {
				outputList.add(li);

			} else if (li.getProductItems().equalsIgnoreCase(this.productValue)
					&& li.getVendor().equalsIgnoreCase(this.vendorValue) && this.citytValue.equalsIgnoreCase("sel")) {
				outputList.add(li);

			} else if (li.getCity().equalsIgnoreCase(this.citytValue) && this.vendorValue.equalsIgnoreCase("sel")
					&& li.getProductItems().equalsIgnoreCase(this.productValue)) {
				outputList.add(li);

			} else if (this.citytValue.equalsIgnoreCase("sel") && this.vendorValue.equalsIgnoreCase("sel")
					&& li.getProductItems().equalsIgnoreCase(this.productValue)) {
				outputList.add(li);

			} else if (this.citytValue.equalsIgnoreCase("sel") && li.getVendor().equalsIgnoreCase(this.vendorValue)
					&& this.productValue.equalsIgnoreCase("sel")) {
				outputList.add(li);

			} else if (this.citytValue.equalsIgnoreCase("sel") && this.vendorValue.equalsIgnoreCase("sel")
					&& this.productValue.equalsIgnoreCase("sel")) {
				outputList.add(li);

			}

		}
		sortList();
		return outputList;
	}

	public void sortList() {
		if (this.radioValue.equalsIgnoreCase("cityR"))
			Collections.sort(outputList, new SortByCity());
		if (this.radioValue.equalsIgnoreCase("VendorR"))
			Collections.sort(outputList, new SortByVendor());
		if (this.radioValue.equalsIgnoreCase("productR"))
			Collections.sort(outputList, new SortByProduct());

	}

}
