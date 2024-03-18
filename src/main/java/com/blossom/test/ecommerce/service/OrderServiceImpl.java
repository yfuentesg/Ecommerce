package com.blossom.test.ecommerce.service;

import com.blossom.test.ecommerce.database.model.Order;
import com.blossom.test.ecommerce.database.model.OrderDetail;
import com.blossom.test.ecommerce.dto.OrderDTO;
import com.blossom.test.ecommerce.dto.OrderDetailDTO;
import com.blossom.test.ecommerce.mapper.OrderDetailMapper;
import com.blossom.test.ecommerce.mapper.OrderMapper;
import com.blossom.test.ecommerce.repository.OrderDetailRepository;
import com.blossom.test.ecommerce.repository.OrderRepository;
import com.blossom.test.ecommerce.request.OrderRequest;
import com.blossom.test.ecommerce.response.OrderResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderDetailMapper orderDetailMapper;

    @Override
    @Transactional
    public OrderDTO addOrder(OrderRequest request) {
        Order order = Order.builder()
                           .clientId(request.getClientId())
                           .orderDate(new Date())
                           .status("A")
                           .deliveryAddress(request.getDeliveryAddress())
                           .build();

        order = orderRepository.save(order);

        for (Integer product: request.getProducts()) {
            OrderDetail od = OrderDetail.builder()
                    .orderId(order.getId())
                    .productId(product)
                    .status("A")
                    .build();
            orderDetailRepository.save(od);
        }

        return orderMapper.toDTO(order);
    }

    @Override
    public OrderResponse getOrder(int id) {
        Order order = orderRepository.findById(id).orElse(null);

        if (order == null) {
            return null;
        }

        List<OrderDetailDTO> orderDetail = orderDetailRepository.findByOrderId(id).stream().map(orderDetailMapper::toDTO).collect(Collectors.toList());

        return OrderResponse
                .builder()
                .clientId(order.getClientId())
                .orderDate(order.getOrderDate())
                .deliveryAddress(order.getDeliveryAddress())
                .id(order.getId())
                .status(order.getStatus())
                .orderDetail(orderDetail)
                .build();
    }

    @Override
    public List<OrderResponse> getOrdersForClient(int clientId) {
        List<OrderResponse> resp = new ArrayList<>();

        for (Integer client: orderRepository.findByClientId(clientId)) {
            resp.add(getOrder(client));
        }

        return resp;
    }

}
