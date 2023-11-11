package com.example.vinay.assignmentspringboot.repository;

import com.example.vinay.assignmentspringboot.entity.Brand;
import com.example.vinay.assignmentspringboot.entity.ProjectTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectTableRepository extends JpaRepository<ProjectTable, Integer>
{
//    List<ProjectTable> findByBrand_BrandName(String brand_name);


//    List<ProjectTable> findByBrand_BrandName(String brandName);

    List<ProjectTable> findByBrand_BrandId(int brandId);
}
