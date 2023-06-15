package com.example.shop.repository;

import com.example.shop.repository.model.ProductCatalogue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCatelogueRepository extends JpaRepository<ProductCatalogue,Integer> {
}
