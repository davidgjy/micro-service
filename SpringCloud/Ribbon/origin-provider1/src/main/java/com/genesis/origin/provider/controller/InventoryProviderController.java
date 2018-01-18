package com.genesis.origin.provider.controller;

import com.genesis.origin.provider.model.Inventory;
import com.genesis.origin.provider.service.impl.InventoryServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: KG
 * @Description:
 * @Date: Created in 下午2:17 2018/1/17
 * @Modified by:
 */

@Api("Inventory相关api")
@RestController
@RequestMapping("/InventoryProvider")
public class InventoryProviderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(InventoryProviderController.class);

    @Autowired
    private InventoryServiceImpl inventoryServiceImpl;

    @ApiOperation(value = "根据id获取入库单")
    @GetMapping(value = "/getInventory/{id}")
    public Inventory getInventory(@PathVariable("id") Integer id) {
        LOGGER.info("origin-provider-1");

        Inventory inventory = inventoryServiceImpl.getInventory(id);

        return inventory;
    }
}
