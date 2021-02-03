package com.qfedu.entity;

import java.util.HashMap;


public class Cart {
	
	private HashMap<String, CartItem> cartItems=new HashMap<String,CartItem>();
	private double total;
	public HashMap<String, CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(HashMap<String, CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
