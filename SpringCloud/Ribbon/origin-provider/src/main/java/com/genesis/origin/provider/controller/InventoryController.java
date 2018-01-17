package com.genesis.origin.provider.controller;

import com.genesis.origin.provider.model.Inventory;
import com.genesis.origin.provider.service.impl.InventoryServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: KG
 * @Description:
 * @Date: Created in 下午2:17 2018/1/17
 * @Modified by:
 */

@Api("Inventory相关api")
@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryServiceImpl inventoryServiceImpl;

    @ApiOperation(value = "根据id获取入库单")
    @GetMapping(value = "/getInventory")
    public Inventory getInventory(@RequestParam("id") Integer id) {
        Inventory inventory = inventoryServiceImpl.getInventory(id);

        return inventory;
    }
}
