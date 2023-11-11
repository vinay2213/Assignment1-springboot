package com.example.vinay.assignmentspringboot.repository;

import com.example.vinay.assignmentspringboot.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

    Brand findByBrandName(String brandName);
}
