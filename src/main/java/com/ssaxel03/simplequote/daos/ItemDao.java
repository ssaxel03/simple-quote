package com.ssaxel03.simplequote.daos;

import com.ssaxel03.simplequote.model.Item;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDao extends GenericDao<Item> implements Dao<Item> {
    public ItemDao() {
        super(Item.class);
    }
}
