package com.example.vinay.assignmentspringboot.service;

import com.example.vinay.assignmentspringboot.entity.Brand;
import com.example.vinay.assignmentspringboot.entity.ProjectTable;
import com.example.vinay.assignmentspringboot.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.vinay.assignmentspringboot.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.RequestParam;


@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ProjectTableService projectTableService;

    public List<Brand> getAllBrands() {
        try {
            return brandRepository.findAll();
        }
        catch (Exception e) {
            throw new ResourceNotFoundException("Error occurred while fetching all brands");
        }
    }

    public List<ProjectTable> getProjectDetails(@RequestParam("brand_name") String brandName) {
        if (brandName.isEmpty()) {
            throw new ResourceNotFoundException("Brand Name is empty");
        }
        try {
            int brandId = findByBrandName(brandName).getBrandId();
            List<ProjectTable> projectdetails = projectTableService.findByBrand_BrandId(brandId);
            return projectdetails;
        }
        catch (Exception e) {
            throw new ResourceNotFoundException("No project details are present for (Brand = " + brandName + ") as this brand does't exists in the database");
        }
    }

    public Brand findByBrandName(String brandName) {
        return brandRepository.findByBrandName(brandName);
    }

}
