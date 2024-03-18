package com.blossom.test.ecommerce.repository;

import com.blossom.test.ecommerce.database.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetail.OrderDetailId> {
    @Query(value = "select o from OrderDetail o where o.orderId = :orderId")
    public List<OrderDetail> findByOrderId(@Param("orderId") int orderId);
}
