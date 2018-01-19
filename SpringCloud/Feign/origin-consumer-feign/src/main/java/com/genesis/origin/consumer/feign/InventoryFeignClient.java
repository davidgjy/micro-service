package com.genesis.origin.consumer.feign;

import com.genesis.origin.consumer.model.Inventory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: KG
 * @Description:
 * @Date: Created in 上午9:07 2018/1/19
 * @Modified by:
 */

@FeignClient(name = "origin-provider")
public interface InventoryFeignClient {
    @RequestMapping(value = "/InventoryProvider/getInventory/{id}", method = RequestMethod.GET)
    Inventory getById(@PathVariable("id") Long id);
}
