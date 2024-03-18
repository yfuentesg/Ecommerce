package com.blossom.test.ecommerce.repository;

import com.blossom.test.ecommerce.database.model.Order;
import com.blossom.test.ecommerce.database.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = "select o.id from Order o where o.clientId = :clientId")
    List<Integer> findByClientId(@Param("clientId") int clientId);
}
