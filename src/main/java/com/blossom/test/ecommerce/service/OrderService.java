package com.blossom.test.ecommerce.service;

import com.blossom.test.ecommerce.dto.OrderDTO;
import com.blossom.test.ecommerce.request.OrderRequest;
import com.blossom.test.ecommerce.response.OrderResponse;

import java.util.List;

public interface OrderService {
    public OrderDTO addOrder(OrderRequest request);
    public OrderResponse getOrder(int id);
    public List<OrderResponse> getOrdersForClient(int clientId);
}
