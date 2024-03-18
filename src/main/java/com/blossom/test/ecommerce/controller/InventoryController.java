package com.blossom.test.ecommerce.controller;

import com.blossom.test.ecommerce.dto.InventoryDTO;
import com.blossom.test.ecommerce.service.InventoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@Api(tags = "Inventory Controller")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @PostMapping
    @ApiOperation("Add a product to inventory")
    public ResponseEntity<InventoryDTO> addInventoryProduct(@RequestBody InventoryDTO inventory) {
        return new ResponseEntity<>(inventoryService.addInventoryProduct(inventory) ,HttpStatus.CREATED);
    }

    @GetMapping("/{datawarehouse}")
    @ApiOperation("Get the whole inventory from a warehouse")
    public ResponseEntity<List<InventoryDTO>> getAllInventoryFromWarehouse(@PathVariable("datawarehouse") String datawarehouse) {
        return new ResponseEntity<>(inventoryService.getAllInventoryFromWarehouse(datawarehouse), HttpStatus.OK);
    }

    @PatchMapping("/{datawarehouse}")
    @ApiOperation("Update products in a warehouse")
    public ResponseEntity<InventoryDTO> updateProductForInventary(@PathVariable("datawarehouse") String datawarehouse, @RequestBody InventoryDTO inventory) {
        return new ResponseEntity<>(inventoryService.updateProductInventory(inventory.getProductId(), datawarehouse, inventory.getTotalProduct()), HttpStatus.OK);
    }

}
