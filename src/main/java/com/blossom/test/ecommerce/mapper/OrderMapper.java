package com.blossom.test.ecommerce.mapper;

import com.blossom.test.ecommerce.database.model.Order;
import com.blossom.test.ecommerce.dto.OrderDTO;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderDTO toDTO(Order o) {
        OrderDTO oDto = new OrderDTO();
        oDto.setId(o.getId());
        oDto.setOrderDate(o.getOrderDate());
        oDto.setStatus(o.getStatus());
        oDto.setClientId(o.getClientId());
        oDto.setDeliveryAddress(o.getDeliveryAddress());
        return oDto;
    }

    public Order toEntity (OrderDTO o) {
        Order order = new Order();
        order.setId(o.getId());
        order.setOrderDate(o.getOrderDate());
        order.setStatus(o.getStatus());
        order.setClientId(o.getClientId());
        order.setDeliveryAddress(o.getDeliveryAddress());
        return order;
    }
}
