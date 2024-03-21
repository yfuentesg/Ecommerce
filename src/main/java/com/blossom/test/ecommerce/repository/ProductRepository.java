package com.blossom.test.ecommerce.repository;

import com.blossom.test.ecommerce.database.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByNameContainingAndPriceGreaterThanAndStatus(String name, Double price, String status);
}
