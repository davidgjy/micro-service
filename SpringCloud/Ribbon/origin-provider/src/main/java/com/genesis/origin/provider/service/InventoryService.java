package com.genesis.origin.provider.service;

import com.genesis.origin.provider.dao.InventoryDao;
import com.genesis.origin.provider.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: KG
 * @Description:
 * @Date: Created in 下午2:15 2018/1/17
 * @Modified by:
 */

@Service
public class InventoryService {
    @Autowired
    private InventoryDao inventoryDao;

    public Inventory getInventory(Integer id) {
        return inventoryDao.getInventoryById(id);
    }
}
