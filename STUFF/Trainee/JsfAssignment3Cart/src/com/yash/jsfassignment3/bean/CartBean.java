package com.yash.jsfassignment3.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.yash.jsfassignment3.service.CartService;
import com.yash.jsfassignment3.service.CartServiceImpl;


@ManagedBean
@SessionScoped
public class CartBean {
	String name;
	int price;
	int quantity;
	List<CartBean> list;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	CartService cartService = new CartServiceImpl();
	
	    public String saveCart(){
		HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String a = req.getParameter("abc");
		int b = Integer.parseInt(req.getParameter("xyz"));
		setPrice(b);
		setName(a);
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		System.out.println((String)((CustomerBean)session.getAttribute("customerBean")).getUserName());
		cartService.insertCart(this,((CustomerBean)session.getAttribute("customerBean")).getUserName());
		
		return "shopping";
	}
	public String proceed(){
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		list = cartService.getCart(((CustomerBean)session.getAttribute("customerBean")).getUserName());
		return "slip";
	}
	public List<CartBean> getList() {
		return list;
	}
	public void setList(List<CartBean> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "CartBean [name=" + name + ", price=" + price + ", quantity="
				+ quantity + "]";
	}
}
