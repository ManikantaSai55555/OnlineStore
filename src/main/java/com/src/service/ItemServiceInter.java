package com.src.service;

import java.util.List;

import com.src.model.Item;

public interface ItemServiceInter {
    public int getItemId(Item item);
    public int addItem(Item item);
    public int deleteItem(Item item);
    public int editItem(Item item);
    public List<Item> displayAllItems();
    public Item getItemsById(int itemid);
    public long getItemPrice(Item item);
}
