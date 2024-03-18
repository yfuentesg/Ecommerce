package com.blossom.test.ecommerce.service;

import com.blossom.test.ecommerce.database.model.Inventory;
import com.blossom.test.ecommerce.dto.InventoryDTO;
import com.blossom.test.ecommerce.mapper.InventoryMapper;
import com.blossom.test.ecommerce.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InventoryServiceImpl implements InventoryService{

    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    InventoryMapper inventoryMapper;

    @Override
    public InventoryDTO addInventoryProduct(InventoryDTO i) {
        i.setLastUpdatedDate(new Date());
        i.setTotalProduct(i.getTotalProduct() == null ? 0 : i.getTotalProduct());

        Inventory inv =  inventoryMapper.toEntity(i);
        inventoryRepository.save(inv);

        return i;
    }

    @Override
    public List<InventoryDTO> getAllInventoryFromWarehouse(String warehouse) {
        return inventoryRepository.findAll().stream().map(inventoryMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public InventoryDTO getProductFromInventory(int productId, String warehouse) {
        Inventory.InventoryId invId = new Inventory.InventoryId(productId, warehouse);
        Optional<Inventory> currentInv = inventoryRepository.findById(invId);

        return currentInv.map(i -> inventoryMapper.toDTO(i)).orElse(null);
    }

    @Override
    public InventoryDTO updateProductInventory(int productId, String warehouse, int total) {
        Inventory.InventoryId invId = new Inventory.InventoryId(productId, warehouse);
        Inventory currentInv = inventoryRepository.findById(invId).orElse(null);

        if (currentInv == null) {
            return null;
        }

        currentInv.setTotalProduct(total);

        return inventoryMapper.toDTO(currentInv);
    }
}
