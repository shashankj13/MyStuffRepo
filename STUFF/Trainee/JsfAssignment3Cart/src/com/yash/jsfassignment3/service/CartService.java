package com.yash.jsfassignment3.service;

import java.util.List;

import com.yash.jsfassignment3.bean.CartBean;

public interface CartService {
	public List<CartBean> getCart(String username);
	public void insertCart(CartBean cb,String username);
	

}
