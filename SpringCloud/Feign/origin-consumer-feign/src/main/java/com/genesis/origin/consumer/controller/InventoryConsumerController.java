package com.genesis.origin.consumer.controller;

import com.genesis.origin.consumer.feign.InventoryFeignClient;
import com.genesis.origin.consumer.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: KG
 * @Description:
 * @Date: Created in 上午9:27 2018/1/19
 * @Modified by:
 */

@RestController
@RequestMapping("/InventoryConsumer")
public class InventoryConsumerController {
    @Autowired
    private InventoryFeignClient inventoryFeignClient;

    @GetMapping("/get/{id}")
    public Inventory findById(@PathVariable Long id) {
        return this.inventoryFeignClient.getById(id);
    }
}
