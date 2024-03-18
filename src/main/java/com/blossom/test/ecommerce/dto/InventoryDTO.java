package com.blossom.test.ecommerce.dto;

import lombok.Data;

import java.util.Date;

@Data
public class InventoryDTO {
    private Integer productId;
    private String warehouse;
    private Integer totalProduct;
    private Date lastUpdatedDate;
}
