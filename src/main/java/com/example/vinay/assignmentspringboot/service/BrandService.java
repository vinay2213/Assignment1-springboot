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

    public List<Brand> getAllBrands()
    {
        try {
            return brandRepository.findAll();
        }
        catch (Exception e)
        {
            throw new ResourceNotFoundException("Error occurred while fetching all brands");
        }
    }

    public Brand findByBrandName(String brandName) {
        Brand brand;
        try
        {
//            return brandRepository.findByBrandName(brandName);
            brand = brandRepository.findByBrandName(brandName);
            if (brandName.isEmpty())
            {
                throw new ResourceNotFoundException("You  have entered a null value" + brandName);
            }

        }
        catch (Exception e)
        {
            throw new ResourceNotFoundException("Brand not found with name: " + brandName);
        }
        return brand;
    }
}






