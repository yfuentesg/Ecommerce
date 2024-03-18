package com.blossom.test.ecommerce.repository;

import com.blossom.test.ecommerce.database.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
