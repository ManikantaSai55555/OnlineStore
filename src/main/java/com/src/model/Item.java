package com.src.model;

public class Item {
	private String itemname;
	private long price;
	private int quantity;
	private String url;
	private String category;
	public Item(String itemname, long price, int quantity, String url, String category) {
        super();
        this.itemname = itemname;
        this.price = price;
        this.quantity = quantity;
        this.url = url;
        this.category = category;
    }
    public Item(String itemname) {
        this.itemname=itemname;
    }
    public Item(String itemname, long price, int quantity) {
        this.itemname=itemname;
        this.price=price;
        this.quantity=quantity;
    }
    public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
