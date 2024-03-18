package com.blossom.test.ecommerce.dto;

import lombok.Data;

@Data
public class OrderDetailDTO {
    private Integer orderId;
    private Integer productId;
    private String status;
}
