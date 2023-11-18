package com.codewithswati.backend.repository;

import com.codewithswati.backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Model and datatype of primary key
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
