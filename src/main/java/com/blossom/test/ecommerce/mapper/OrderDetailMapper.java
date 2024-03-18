package com.blossom.test.ecommerce.mapper;

import com.blossom.test.ecommerce.database.model.OrderDetail;
import com.blossom.test.ecommerce.dto.OrderDetailDTO;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailMapper {

    public OrderDetailDTO toDTO(OrderDetail o) {
        OrderDetailDTO oDetDto = new OrderDetailDTO();
        oDetDto.setOrderId(o.getOrderId());
        oDetDto.setStatus(o.getStatus());
        oDetDto.setProductId(o.getProductId());
        return oDetDto;
    }

    public OrderDetail toEntity(OrderDetailDTO oDto) {
        OrderDetail od = new OrderDetail();
        od.setOrderId(oDto.getOrderId());
        od.setStatus(oDto.getStatus());
        od.setProductId(oDto.getProductId());
        return od;
    }
}
