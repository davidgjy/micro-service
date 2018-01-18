package com.genesis.origin.provider.dao;

import com.genesis.origin.provider.mapper.InventoryMapper;
import com.genesis.origin.provider.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author: KG
 * @Description:
 * @Date: Created in 下午1:53 2018/1/17
 * @Modified by:
 */

@Repository
public class InventoryDao {
    @Autowired
    private InventoryMapper inventoryMapper;

    public Inventory getInventoryById(Integer id) {
        return inventoryMapper.selectByPrimaryKey(id);
    }
}
