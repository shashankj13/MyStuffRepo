package com.yash.productSearchSystem.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.faces.bean.ManagedProperty;

import com.yash.productSearchSystem.bean.ProductBean;

@Stateless
public class ProductService implements ProductServiceLocal {

	@ManagedProperty(value="productBean")
	ProductBean productBean;
	
    
    public ProductService() {
       
    }

	@Override
	public List<Object> displayList() {
		return null;
		
	}

}
