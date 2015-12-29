package com.yash.productSearchSystem.service;

import javax.ejb.Local;

@Local
public interface ProductServiceLocal {
	
	public Object displayList();
}
