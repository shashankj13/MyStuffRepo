package com.yash.productSearchSystem.helper;

import java.util.Comparator;

import com.yash.productSearchSystem.pojo.Product;

public class SortByProduct implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		return o1.getProductItems().compareToIgnoreCase(o2.getProductItems());
	}

}
