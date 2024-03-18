package com.blossom.test.ecommerce.database.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "blossom_orderdetail")
@IdClass(OrderDetail.OrderDetailId.class)
@Builder
@Data
public class OrderDetail {

    @AllArgsConstructor
    @NoArgsConstructor
    public static class OrderDetailId implements Serializable {
        private Integer orderId;
        private Integer productId;
    }

    @Id
    private Integer orderId;
    @Id
    private Integer productId;
    private String status;


}
