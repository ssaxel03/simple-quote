package com.ssaxel03.simplequote.services;

import com.ssaxel03.simplequote.daos.ItemDao;
import com.ssaxel03.simplequote.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private ItemDao itemDao;

    public List<Item> getItems() {
        return itemDao.findAll();
    }

    public Item getItem(int id) {
        return itemDao.findById(id);
    }

    public void saveOrUpdateItemToList(Item item) {
        itemDao.saveOrUpdate(item);
    }

    public void removeItemFromList(Item item) {
        itemDao.delete(item);
    }

    public ItemDao getItemDao() {
        return itemDao;
    }
    @Autowired
    public void setItemDao(ItemDao itemDao) {
        this.itemDao = itemDao;
    }
}
