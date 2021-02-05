package com.qfedu.entity;

import java.util.Date;

public class Product {

	/*CREATE TABLE `product` (
			  `pid` varchar(32) NOT NULL,
			  `pname` varchar(50) DEFAULT NULL,
			  `market_price` double DEFAULT NULL,
			  `shop_price` double DEFAULT NULL,
			  `pimage` varchar(200) DEFAULT NULL,
			  `pdate` date DEFAULT NULL,
			  `is_hot` int(11) DEFAULT NULL,
			  `pdesc` varchar(255) DEFAULT NULL,
			  `pflag` int(11) DEFAULT NULL,
			  `cid` varchar(32) DEFAULT NULL,
			  PRIMARY KEY (`pid`),
			  KEY `sfk_0001` (`cid`),*/
	private String pid;
	private String pname;
	private Double market_price;
	private Double shop_price;
	private String pimage;
	private String pdate;
	private int is_hot;
	private String pdesc;
	private int pflag;
	private Category Category;
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String pid, String pname, Double market_price, Double shop_price, String pimage, String pdate, int is_hot, String pdesc, int pflag, com.qfedu.entity.Category category) {
		this.pid = pid;
		this.pname = pname;
		this.market_price = market_price;
		this.shop_price = shop_price;
		this.pimage = pimage;
		this.pdate = pdate;
		this.is_hot = is_hot;
		this.pdesc = pdesc;
		this.pflag = pflag;
		Category = category;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Double getMarket_price() {
		return market_price;
	}

	public void setMarket_price(Double market_price) {
		this.market_price = market_price;
	}

	public Double getShop_price() {
		return shop_price;
	}

	public void setShop_price(Double shop_price) {
		this.shop_price = shop_price;
	}

	public String getPimage() {
		return pimage;
	}

	public void setPimage(String pimage) {
		this.pimage = pimage;
	}

	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}

	public int getIs_hot() {
		return is_hot;
	}

	public void setIs_hot(int is_hot) {
		this.is_hot = is_hot;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public int getPflag() {
		return pflag;
	}

	public void setPflag(int pflag) {
		this.pflag = pflag;
	}

	public com.qfedu.entity.Category getCategory() {
		return Category;
	}

	public void setCategory(com.qfedu.entity.Category category) {
		Category = category;
	}

	@Override
	public String toString() {
		return "Product{" +
				"pid='" + pid + '\'' +
				", pname='" + pname + '\'' +
				", market_price=" + market_price +
				", shop_price=" + shop_price +
				", pimage='" + pimage + '\'' +
				", pdate='" + pdate + '\'' +
				", is_hot=" + is_hot +
				", pdesc='" + pdesc + '\'' +
				", pflag=" + pflag +
				", Category=" + Category +
				'}';
	}
}
