package com.qfedu.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

	//创建订单
	private String oid;//该订单的订单号
	private Date ordertime;//下单的时间
	private double total;//该订单的总金额
	private int state;//订单的支付状态 1表示已付款 0 表示未付款

	private String address;//商品的收获地址
	private String name;//收货人姓名
	private String telephone;//收货人电话

	private User user;//带订单属于哪个用户
	private List<OrderItem> orderItem=new ArrayList<>();
	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Order{" +
				"oid='" + oid + '\'' +
				", ordertime=" + ordertime +
				", total=" + total +
				", state=" + state +
				", address='" + address + '\'' +
				", name='" + name + '\'' +
				", telephone='" + telephone + '\'' +
				", user=" + user +
				", orderItem=" + orderItem +
				'}';
	}
}
