package com.src.model;

public class Order {
	private int itemid;
	private int userid;
	private int orderQuantity;
	private long orderPrice;
	private String status;
	public Order(int itemid, int userid, int orderQuantity, long orderPrice,String status) {
        super();
        this.itemid = itemid;
        this.userid = userid;
        this.orderQuantity = orderQuantity;
        this.orderPrice = orderPrice;
        this.status=status;
    }
    public Order(int itemid, int uid) {
        this.itemid=itemid;
        this.userid=uid;
    }
    public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public long getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(long orderPrice) {
		this.orderPrice = orderPrice;
	}
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
