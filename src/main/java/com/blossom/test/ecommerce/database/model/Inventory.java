package com.blossom.test.ecommerce.database.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "blossom_inventory")
@Data
@IdClass(Inventory.InventoryId.class)
public class Inventory {

    @AllArgsConstructor
    @NoArgsConstructor
    public static class InventoryId implements Serializable {
        private Integer productId;
        private String warehouse;
    }

    @Id
    private Integer productId;
    @Id
    private String warehouse;
    private Integer totalProduct;
    private Date lastUpdatedDate;
}
