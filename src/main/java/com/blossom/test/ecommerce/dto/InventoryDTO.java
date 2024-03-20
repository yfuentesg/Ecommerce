package com.blossom.test.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDTO {
    private Integer productId;
    private String warehouse;
    private Integer totalProduct;
    private Date lastUpdatedDate;
}
