package com.example.vinay.assignmentspringboot.service;

import com.example.vinay.assignmentspringboot.entity.Brand;
import com.example.vinay.assignmentspringboot.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.vinay.assignmentspringboot.exception.ResourceNotFoundException;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public List<Brand> getAllBrands() {
        try {
            return brandRepository.findAll();
        }
        catch (Exception e) {
            throw new ResourceNotFoundException("Error occurred while fetching all brands");
        }
    }

    public Brand findByBrandName(String brandName) {
        return brandRepository.findByBrandName(brandName);
    }

}
