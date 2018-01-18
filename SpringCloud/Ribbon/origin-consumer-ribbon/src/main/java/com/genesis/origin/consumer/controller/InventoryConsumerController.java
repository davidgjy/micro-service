package com.genesis.origin.consumer.controller;

import com.genesis.origin.consumer.model.Inventory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: KG
 * @Description:
 * @Date: Created in 上午10:06 2018/1/18
 * @Modified by:
 */

@RestController
@RequestMapping("/InventoryConsumer")
public class InventoryConsumerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(InventoryConsumerController.class);

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/get/{id}")
    public Inventory getInventoryById(@PathVariable Long id) {
        return this.restTemplate.getForObject("http://origin-provider/InventoryProvider/getInventory/" + id, Inventory.class);
    }

    @GetMapping("/get-inventory-instance")
    public void logUserInstance() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("origin-provider");

        // 打印当前选择的是哪个节点
        InventoryConsumerController.LOGGER.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
    }
}
