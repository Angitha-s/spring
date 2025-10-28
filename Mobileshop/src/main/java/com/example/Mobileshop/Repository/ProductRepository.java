package com.example.Mobileshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Mobileshop.Models.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Integer> {
}