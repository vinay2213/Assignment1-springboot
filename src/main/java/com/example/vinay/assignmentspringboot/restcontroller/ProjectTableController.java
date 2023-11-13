package com.example.vinay.assignmentspringboot.restcontroller;

import com.example.vinay.assignmentspringboot.entity.Brand;
import com.example.vinay.assignmentspringboot.entity.ProjectTable;
import com.example.vinay.assignmentspringboot.repository.BrandRepository;
import com.example.vinay.assignmentspringboot.repository.ProjectTableRepository;
import com.example.vinay.assignmentspringboot.service.BrandService;
import com.example.vinay.assignmentspringboot.service.ProjectTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectTableController
{
    @Autowired
    private ProjectTableService projectTableService;

    @Autowired
    private BrandService brandService;

//    @Autowired
//    private BrandRepository brandRepository;
//
//    @Autowired
//    private ProjectTableRepository projectTableRepository;
//
//    @GetMapping("/details")
//    public List<ProjectTable> getBrandDetails(@RequestParam ("brand_name") String brandName){
//
//        int brandId = brandRepository.findByBrandName(brandName).getBrandId();
//        return projectTableRepository.findByBrand_BrandId(brandId);
//    }

        @GetMapping("/projectdetails")
        public List<ProjectTable> getBrandDetails(@RequestParam ("brand_name") String brandName){

        int brandId = brandService.findByBrandName(brandName).getBrandId();
        List<ProjectTable> projectdetails = projectTableService.findByBrand_BrandId(brandId);
        return projectdetails;
    }
}
