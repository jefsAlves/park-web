package com.alvesjefs.parkweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alvesjefs.parkweb.domain.Products;

public interface ProductsRepository extends JpaRepository<Products, Long> {

}
