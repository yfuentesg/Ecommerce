package com.blossom.test.ecommerce.controller;

import com.blossom.test.ecommerce.dto.OrderDTO;
import com.blossom.test.ecommerce.request.OrderRequest;
import com.blossom.test.ecommerce.response.OrderResponse;
import com.blossom.test.ecommerce.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@Api(tags = "Order Controller")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    @ApiOperation("Creates an order")
    public ResponseEntity<OrderDTO> addOrder(@RequestBody OrderRequest order) {
        return new ResponseEntity<>(orderService.addOrder(order), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ApiOperation("Gets the order info")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable("id") int id) {
        return new ResponseEntity<>(orderService.getOrder(id), HttpStatus.OK);
    }

    @GetMapping("/client/{idClient}")
    @ApiOperation("Gets Orders for and specific client")
    public ResponseEntity<List<OrderResponse>> getOrderForClient(@PathVariable("idClient") int idClient) {
        return new ResponseEntity<>(orderService.getOrdersForClient(idClient), HttpStatus.OK);
    }
}
