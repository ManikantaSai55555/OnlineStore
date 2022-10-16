package com.src.service;

import java.util.List;

import com.src.dao.ItemsDaoImpl;
import com.src.dao.ItemsDaoInter;
import com.src.model.Item;

public class ItemServiceImpl implements ItemServiceInter {

    ItemsDaoInter idi=new ItemsDaoImpl();
    @Override
    public int addItem(Item item) {
        // TODO Auto-generated method stub
        return idi.addItem(item);
    }

    @Override
    public int deleteItem(Item item) {
        // TODO Auto-generated method stub
        return idi.deleteItem(item);
    }

    @Override
    public int editItem(Item item) {
        // TODO Auto-generated method stub
        return idi.editItem(item);
    }

    @Override
    public List<Item> displayAllItems() {
        // TODO Auto-generated method stub
        return idi.displayAllItems();
    }

    @Override
    public int getItemId(Item item) {
        return idi.getItemId(item);
    }

    @Override
    public long getItemPrice(Item item) {
        return idi.getItemPrice(item);
    }

    @Override
    public Item getItemsById(int itemid) {
        return idi.getItemsById(itemid);
    }

}
