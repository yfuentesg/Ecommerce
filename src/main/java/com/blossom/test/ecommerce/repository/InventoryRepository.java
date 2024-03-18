package com.blossom.test.ecommerce.repository;

import com.blossom.test.ecommerce.database.model.Inventory;
import com.blossom.test.ecommerce.dto.InventoryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Inventory.InventoryId> {

}
