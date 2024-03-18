package com.blossom.test.ecommerce.response;

import com.blossom.test.ecommerce.dto.OrderDetailDTO;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Builder
@Data
public class OrderResponse {
    private Integer id;
    private Date orderDate;
    private String status;
    private Integer clientId;
    private String deliveryAddress;
    List<OrderDetailDTO> orderDetail;
}
