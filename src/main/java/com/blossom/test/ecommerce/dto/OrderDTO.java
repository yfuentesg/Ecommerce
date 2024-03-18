package com.blossom.test.ecommerce.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderDTO {
    private Integer id;
    private Date orderDate;
    private String status;
    private Integer clientId;
    private String deliveryAddress;
}
