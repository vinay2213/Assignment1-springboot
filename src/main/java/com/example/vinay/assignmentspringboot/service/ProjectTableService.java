package com.example.vinay.assignmentspringboot.service;

import com.example.vinay.assignmentspringboot.entity.ProjectTable;
import com.example.vinay.assignmentspringboot.exception.ResourceNotFoundException;
import com.example.vinay.assignmentspringboot.repository.ProjectTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Service
public class ProjectTableService {

    @Autowired
    private ProjectTableRepository projectTableRepository;

    @Autowired
    private BrandService brandService;

//    public List<ProjectTable> getProjectDetails(@RequestParam("brand_name") String brandName) {
//        if (brandName.isEmpty()) {
//            throw new ResourceNotFoundException("Brand Name is empty");
//        }
//
//        if (brandService.findByBrandName(brandName) == null) {
//            throw new ResourceNotFoundException("This brand is not present in the database");
//        }
//
//        try {
//            int brandId = brandService.findByBrandName(brandName).getBrandId();
//            List<ProjectTable> projectDetails = findByBrand_BrandId(brandId);
//            return projectDetails;
//        }
//        catch (Exception e) {
//            throw new ResourceNotFoundException("No project details are present for (Brand = " + brandName + ")");
//        }
//    }
//
//    public List<ProjectTable> findByBrand_BrandId(int brandId){
//            if(projectTableRepository.findByBrand_BrandId(brandId).isEmpty()) {
//                throw new ResourceNotFoundException("No projects exist with brandId : " + brandId);
//            }
//            return projectTableRepository.findByBrand_BrandId(brandId);
//    }


    public List<ProjectTable> getProjectsByBrandName(@RequestParam("brand_name") String brandName) throws Exception {
        if (brandName.isEmpty()) {
            throw new ResourceNotFoundException("Brand Name is empty");
        }

        if (brandService.findByBrandName(brandName) == null) {
            throw new ResourceNotFoundException("This brand is not present in the database");
        }

        List<ProjectTable> projectDetails = null;

        try {
            projectDetails= projectTableRepository.findByBrand_BrandName(brandName);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        if(projectDetails.isEmpty()) {
            throw new ResourceNotFoundException("No project details are present for (Brand = " + brandName + ")");
        }

        return projectDetails;
    }
}
