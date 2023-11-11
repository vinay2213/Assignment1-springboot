package com.example.vinay.assignmentspringboot.repository;

import com.example.vinay.assignmentspringboot.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
