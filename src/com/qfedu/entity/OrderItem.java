package com.qfedu.entity;

public class OrderItem {

	//创建订单项
	private String itemid;//订单项的id
	private int count;//订单项内商品购买的数量
	private double subtotal;//订单小计
	private Product product;//订单项内部的商品
	private Order order;//该订单项属于哪个订单
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderItem{" +
				"itemid='" + itemid + '\'' +
				", count=" + count +
				", subtotal=" + subtotal +
				", product=" + product +
				", order=" + order +
				'}';
	}
}
