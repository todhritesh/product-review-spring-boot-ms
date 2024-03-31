package com.dhritesh.productms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhritesh.productms.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
    
}
