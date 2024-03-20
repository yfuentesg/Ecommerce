package com.blossom.test.ecommerce.service;

import com.blossom.test.ecommerce.database.model.Inventory;
import com.blossom.test.ecommerce.dto.InventoryDTO;
import com.blossom.test.ecommerce.mapper.InventoryMapper;
import com.blossom.test.ecommerce.repository.InventoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InventoryServiceImplTest {

    @InjectMocks
    InventoryServiceImpl inventoryService;

    @Mock
    InventoryRepository inventoryRepository;
    @Mock
    InventoryMapper inventoryMapper;


    @Test
    @DisplayName("Test addInventoryProduct")
    void addInventoryProduct() {
        //given
        InventoryDTO inventoryDTO = InventoryDTO
                .builder()
                .productId(any())
                .warehouse(anyString())
                .totalProduct(any())
                .lastUpdatedDate(new Date())
                .build();

        //when
        when(inventoryMapper.toEntity(inventoryDTO)).thenReturn(new Inventory());
        doReturn(new Inventory()).when(inventoryRepository).save(new Inventory());

        //then
        assertNotNull(inventoryService.addInventoryProduct(inventoryDTO));
    }

    @Test
    void getAllInventoryFromWarehouse() {
    }

    @Test
    void getProductFromInventory() {
    }

    @Test
    void updateProductInventory() {
    }
}