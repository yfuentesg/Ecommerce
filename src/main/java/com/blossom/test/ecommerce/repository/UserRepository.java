package com.blossom.test.ecommerce.repository;

import com.blossom.test.ecommerce.database.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    User findByName(String name);
}
