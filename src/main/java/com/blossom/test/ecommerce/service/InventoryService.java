package com.blossom.test.ecommerce.service;

import com.blossom.test.ecommerce.dto.InventoryDTO;

import java.util.List;

public interface InventoryService {
    public InventoryDTO addInventoryProduct(InventoryDTO i);
    public List<InventoryDTO> getAllInventoryFromWarehouse(String warehouse);
    public InventoryDTO getProductFromInventory(int productId, String warehouse);
    public InventoryDTO updateProductInventory(int productId, String warehouse, int total);
}
