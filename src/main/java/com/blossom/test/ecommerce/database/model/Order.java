package com.blossom.test.ecommerce.database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "blossom_order")
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private Date orderDate;
    private String status;
    private Integer clientId;
    private String deliveryAddress;
}
