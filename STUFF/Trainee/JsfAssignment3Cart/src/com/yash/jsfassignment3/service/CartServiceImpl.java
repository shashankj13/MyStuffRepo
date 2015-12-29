package com.yash.jsfassignment3.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.yash.jsfassignment3.bean.CartBean;
import com.yash.jsfassignment3.dao.CartDao;
import com.yash.jsfassignment3.dao.CartDaoImpl;

public class CartServiceImpl implements CartService{
	
	CartDao cartDao = new CartDaoImpl();
	List<CartBean> list = new ArrayList<>();
	
	
	public void insertCart(CartBean cartbean,String username) {
		String sql = "INSERT INTO CART VALUES("+cartbean.getQuantity()+" , "+cartbean.getPrice()+" , '"+cartbean.getName()+"' , '"+username+"')";
		cartDao.update(sql);
	}
	
	
	public List<CartBean> getCart(String username){
		String sql = "Select * from Cart where username='"+ username +"'";
		System.out.println(sql);
		ResultSet resultSet = cartDao.select(sql);
		try{
			while(resultSet.next()){
				CartBean cartbean= new CartBean();
				cartbean.setName(resultSet.getString(3));
				cartbean.setPrice(resultSet.getInt(2));
				cartbean.setQuantity(resultSet.getInt(1));
				list.add(cartbean);
				
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
		
	}

}
