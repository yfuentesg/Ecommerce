package com.blossom.test.ecommerce.mapper;

import com.blossom.test.ecommerce.database.model.Inventory;
import com.blossom.test.ecommerce.dto.InventoryDTO;
import org.springframework.stereotype.Component;

@Component
public class InventoryMapper {
    public InventoryDTO toDTO(Inventory i) {
        InventoryDTO inv = new InventoryDTO();

        inv.setProductId(i.getProductId());
        inv.setWarehouse(i.getWarehouse());
        inv.setTotalProduct(i.getTotalProduct());
        inv.setLastUpdatedDate(i.getLastUpdatedDate());

        return inv;
    }

    public Inventory toEntity(InventoryDTO iDto) {
        Inventory i = new Inventory();

        i.setProductId(iDto.getProductId());
        i.setWarehouse(iDto.getWarehouse());
        i.setTotalProduct(iDto.getTotalProduct());
        i.setLastUpdatedDate(iDto.getLastUpdatedDate());

        return i;
    }
}
