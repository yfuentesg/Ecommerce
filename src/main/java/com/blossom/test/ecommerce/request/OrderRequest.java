package com.blossom.test.ecommerce.request;

import com.blossom.test.ecommerce.dto.OrderDTO;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderRequest {
    private Date orderDate;
    private Integer clientId;
    private String deliveryAddress;
    private List<Integer> products;
}
