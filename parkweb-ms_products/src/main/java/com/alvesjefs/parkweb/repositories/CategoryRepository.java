package com.alvesjefs.parkweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alvesjefs.parkweb.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
